import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for(int i  = 0 ; i < nums.length-1 ; i ++){
            for(int j = i +1; j < nums.length ; j ++){
                if(nums[i]+ nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
      Map<Integer,Integer> map = new HashMap<>();
      for (int i = 0 ; i < nums.length ; i ++){
          int num = target-nums[i];
          if(map.containsKey(num)){
              return new int[]{map.get(num),i};
          }
          map.put(nums[i],i);
      }
        throw new IllegalArgumentException("No two sum solution");
    }


}

//https://free-vpn.github.io/chrome/   谷歌浏览器下载地址
