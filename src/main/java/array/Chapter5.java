package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 多数元素   https://leetcode-cn.com/problems/majority-element/
 * <p>
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @auther forewei
 * @date 2020/7/3
 */
public class Chapter5 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = nums.length / 2;
        int[] target = new int[]{0, 0};
        int temp = 1;

        for (int i = 0; i <= nums.length / 2; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] == nums[j]) {
                    temp++;
                    if (temp > count ) {
                        if (temp > target[1]) {
                            target[0] = nums[i];
                            target[1] = temp;
                        } else {
                            target[0] = nums[i];
                            target[1] = temp;
                        }
                    }
                }
            }
            if (i == nums.length / 2) {
                return target[0];
            }
            temp = 1;
        }

        return 0;
    }

    @Test
    public void test() {
        int[] nums = {3,2,3};
        System.out.println(this.majorityElement(nums));
    }
}
