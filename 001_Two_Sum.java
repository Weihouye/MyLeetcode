package java;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一题：两数之和
 * 描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 *
 * Created by Administrator on 2019/9/28.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();   //map存储nums数组遍历过的数值及其下标，数值为key，下标为value
        for (int i=0;i<nums.length;i++){
            int x = nums[i];      //遍历数组
            if(map.containsKey(target - x)){   //当map包含某个key = target - x (x为数组当前遍历的数值)
                return new int[]{map.get(target - x),i}; //返回两个数的下标
            }
            map.put(x,i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}