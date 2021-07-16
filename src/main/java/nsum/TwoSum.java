package nsum;

import java.util.*;

/**
 *
 * https://leetcode-cn.com/problems/two-sum
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
 *
 * https://labuladong.github.io/algo/2/21/55/
 * https://labuladong.github.io/algo/1/11/
 * https://labuladong.github.io/algo/2/21/50/
 *
 * nums = [3,1,3,6] target = 6, result = [3, 3]
 *
 * 总结：对于无序数组可通过暴力穷尽，或者用 HashMap 优化内层循环，空间换时间。
 * 再或者排序之后使用双指针
 *
 * @author Jie.LJ.Liu
 * @date 2021/7/16 10:23
 */
public class TwoSum {


    /**
     * Time: O(N^2), Space: O(1)
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] twoSum1(int[] nums, int target) {

        int[] noValidResult = new int[]{-1, -1};
        if (Objects.isNull(nums) || nums.length == 0) {
            return noValidResult;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return noValidResult;
    }


    /**
     * Time: O(N), Space: O(1)
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] noValidResult = new int[]{-1, -1};
        if (Objects.isNull(nums) || nums.length == 0) {
            return noValidResult;
        }

        Map<Integer, Integer> hash = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (hash.containsKey(other) && hash.get(other) != i) {
                return new int[]{nums[i], hash.get(other)};
            }
            /*for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{nums[i], nums[j]};
                }
            }*/
        }
        return noValidResult;
    }


    /**
     *  先排序，然后用双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int[] noValidResult = new int[]{-1, -1};
        if (Objects.isNull(nums) || nums.length == 0) {
            return noValidResult;
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{nums[left], nums[right]};
            } else if(sum<target) {
                left++;
            } else {
                right--;
            }
        }
        return noValidResult;
    }


    /**
     * 返回 NSum 所有组合
     * @param nums
     * @param target
     * @return
     */
    public List<int[]> twoSumAll(int[] nums, int target) {
        List<int[]> noValidListResult = Collections.emptyList();
        if (Objects.isNull(nums) || nums.length == 0) {
            return noValidListResult;
        }

        Arrays.sort(nums);
        List<int[]> vaildListResult = new ArrayList<>();

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (target == sum) {
                vaildListResult.add(new int[]{left, right});
                while (lo < hi && nums[lo] == left) lo ++;
                while (lo < hi && nums[right] == right) hi ++;
            } else if(sum < target) {
                while (lo < hi && nums[lo] == left) lo ++;
            } else {
                while (lo < hi && nums[right] == right) hi ++;
            }
        }
        return noValidListResult;
    }

}
