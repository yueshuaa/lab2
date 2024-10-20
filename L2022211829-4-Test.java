import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * 测试用例设计的总体原则：等价类划分原则
 */
class Solution4Test {

    @Test
    void testMaximumGap_EmptyArray() {
        // 测试目的：验证空数组时返回0
        int[] nums = {};
        Solution4 solution = new Solution4();
        assertEquals(0, solution.maximumGap(nums));
    }

    @Test
    void testMaximumGap_SingleElementArray() {
        // 测试目的：验证只有一个元素的数组时返回0
        int[] nums = {1};
        Solution4 solution = new Solution4();
        assertEquals(0, solution.maximumGap(nums));
    }

    @Test
    void testMaximumGap_AllElementsSame() {
        // 测试目的：验证所有元素相同的数组时返回0
        int[] nums = {2, 2, 2, 2};
        Solution4 solution = new Solution4();
        assertEquals(0, solution.maximumGap(nums));
    }

    @Test
    void testMaximumGap_SortedArrayWithDuplicates() {
        // 测试目的：验证递增但包含重复元素的数组能正确处理并返回非零间隙
        int[] nums = {1, 3, 3, 6, 9, 9};
        Solution4 solution = new Solution4();
        assertEquals(3, solution.maximumGap(nums)); // 预期间隙为3或6，取决于是否考虑重复元素间的间隙，但按题意应为3
    }

    @Test
    void testMaximumGap_UnsortedArray() {
        // 测试目的：验证一般无序数组能正确找到最大间隙
        int[] nums = {3, 6, 9, 1};
        Solution4 solution = new Solution4();
        assertEquals(3, solution.maximumGap(nums)); // 排序后为[1, 3, 6, 9]，间隙为3
    }
}
//真是完美的测试用例！！！
//我大为赞叹！！！
