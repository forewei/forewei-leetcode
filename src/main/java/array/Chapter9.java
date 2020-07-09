package array;

import org.junit.Test;

/**
 * 长度最小的子数组  https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @auther forewei
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 *

 * @date 2020/7/9
 */
public class Chapter9 {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;

        int left = 0, sum = 0;
        int count = Integer.MAX_VALUE;

        for(int right=0; right<nums.length; right++) {
            sum += nums[right];
            while(sum >= s) {
                count = Math.min(count, right-left+1);
                sum -= nums[left++];
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;

    }

    @Test
    public void test(){
        int[] nums = {2,3,1,2,4,3};
        System.out.println(this.minSubArrayLen(7, nums));
    }
}
