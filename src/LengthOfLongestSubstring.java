import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p/>
 * Example 1:
 * <p/>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p/>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p/>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(i))) {
                i = Math.max(map.get(s.charAt(i)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        int num = 0;
        char[] chars = s.toCharArray();
        int flag = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; ) {
            if (!list.contains(chars[i])) {
                list.add(chars[i]);
                if (list.size() > num) {
                    num = list.size();
                }
                i++;
            } else {
                list.clear();
                i = flag++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "abcadeb";
        System.out.println(lengthOfLongestSubstring2(str));
    }
}
