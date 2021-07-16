package nsum;

import java.util.*;

/**
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485789&idx=1&sn=efc1167b85011c019e05d2c3db1039e6
 *
 * @author Jie.LJ.Liu
 * @date 2021/7/16 11:27
 */
public class ThreeSum {


    /**
     * 可能会有重复
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum(List<Integer> nums, int target) {

        if (Objects.isNull(nums) || nums.isEmpty()) {
            return Collections.emptyList();
        }

        Collections.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<List<Integer>> twoSumResultList = twoSum(nums, target - nums.get(i), i + 1, true);
            for (List<Integer> integers : twoSumResultList) {
                resultList.add(Arrays.asList(nums.get(i), integers.get(0), integers.get(1)));
            }
            while (i < nums.size() -1 && nums.get(i) == nums.get(i + 1)) i++;
        }


        return resultList;
    }


    /**
     * 可能会重复
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSum(List<Integer> nums, int target) {
        return twoSum(nums, target, 0, false);
    }



    /**
     * 可能会重复
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSum(List<Integer> nums, int target, int startIndex, boolean isSorted) {

        if (Objects.isNull(nums) || nums.isEmpty() || startIndex > nums.size()) {
            return Collections.emptyList();
        }
        if (!isSorted) {
            Collections.sort(nums);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        int lo = startIndex, hi = nums.size() - 1;
        while (lo < hi) {
            int left = nums.get(lo), right = nums.get(hi);
            int sum = left + right;
            if (sum == target) {
                resultList.add(Arrays.asList(left, right));
                while (lo < hi && nums.get(lo) == left) lo ++;
                while (lo < hi && nums.get(hi) == right) hi --;
            } else if (sum < target) {
                while (lo < hi && nums.get(lo) == left) lo ++;
            } else {
                while (lo < hi && nums.get(hi) == right) hi --;
            }
        }
        return resultList;
    }

}
