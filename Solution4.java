import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 */
class Solution4 {
    public int maximumGap(int[] nums) {

        int n = nums.length - 1;
        if (n < 1) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();//最大值

        while (maxVal > exp) {// 当当前位还有数字时继续循环
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;// 计算当前位的数字
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++){
                cnt[i] += cnt[i - 1];// 累积计数，确定每个数字在排序后的位置
            }
            for (int i = n - 1; i >= 0; i--) {// 从后向前遍历
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];// 放置元素到正确位置
                cnt[digit]--;// 更新计数
            }
            System.arraycopy(buf, 0, nums, 0, n);// 将排序后的元素复制回原数组
            exp *= 10; // 移动到下一位

        }
        int ret = 0;
            for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

}
//到此一游！



