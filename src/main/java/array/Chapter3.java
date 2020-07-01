package array;

import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.shaded.org.apache.http.util.Asserts;

/**
 * 搜索旋转排序数组    https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @auther forewei
 * @date 2020/7/1
 */
public class Chapter3 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            return target == nums[0]?0:-1;
        }

        int l=0,r=len-1;
        while(r>=l) {
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            if(nums[0]<=nums[mid]) {
                if(target>=nums[0]&&target<nums[mid]) {
                    r= mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(target>nums[mid]&&target<=nums[len-1]) {
                    l = mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int nums[] = {4,5,6,7,0,1,2};
        Assert.assertEquals(4,this.search(nums,0));
    }
}
