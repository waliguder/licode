package zt.licode.lc_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 我的解答
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // 循环第一层
        for (int i = 0; i < nums.length; i++) {
            // 循环第二层，从j=i+1开始
            for (int j = i + 1; j < nums.length; j++) {
                // 判断相加是否符合target
                if (nums[i] + nums[j] == target) {
                    // 找到就返回下标数组
                    return new int[]{i, j};
                }
            }
        }
        // 否则返回空数组
        return new int[0];
    }


    /**
     * 官方解答
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 新建一个hashmap，key为target-x，value为当前数组的下标
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        // 第一次循环
        for (int i = 0; i < nums.length; ++i) {
            // 判断当前的hashmap中是否存在target-x的key，有就找到了，返回下标数组即可
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 没找到，就将当前的target-x存入
            hashtable.put(nums[i], i);
        }
        // 没有则返回空数组
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

}
