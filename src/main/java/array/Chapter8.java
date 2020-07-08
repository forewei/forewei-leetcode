package array;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * 存在重复元素 III    https://leetcode-cn.com/problems/contains-duplicate-iii/
 * <p>
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * @auther forewei
 * @date 2020/7/8
 */
public class Chapter8 {
    /**
     * 暴力解法 提交超市
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (this.abs((long)nums[i] - nums[j]) <= t && this.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 树 实现
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        Set<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i ++){

            if(((TreeSet<Long>) set).ceiling((long)nums[i]-t) != null && ((TreeSet<Long>) set).ceiling((long)nums[i]-t) - t <= nums[i] )
                return true;

            set.add( (long)nums[i] );
            if(set.size() == k + 1)
                set.remove( (long)nums[i - k]);
        }

        return false;
    }

    public long abs(long i) {
        return i > 0 ? i : -i;
    }

    @Test
    public void test() {
        int[] nums = {2147483647,-2147483647};
        System.out.println(this.containsNearbyAlmostDuplicate(nums, 1, 2147483647));

    }
}
