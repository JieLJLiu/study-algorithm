package nsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jie.LJ.Liu
 * @date 2021/7/16 14:52
 */
public class ThreeSumTest {

    @Test
    public void testThreeSum() {

        List<Integer> nums = Arrays.asList(-1, 0, 1, 2, -1, -4);
        int target = 0;
        List<List<Integer>> result = new ThreeSum().threeSum(nums, target);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertArrayEquals(new Integer[]{-1, -1, 2}, result.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[]{-1, 0, 1}, result.get(1).toArray(new Integer[0]));


    }


    @Test
    public void testTwoSum() {

        List<Integer> nums = Arrays.asList(1, 3, 1, 2, 2, 3);
        int target = 4;
        List<List<Integer>> result = new ThreeSum().twoSum(nums, target);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertArrayEquals(new Integer[]{1, 3}, result.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[]{2, 2}, result.get(1).toArray(new Integer[0]));


    }
}
