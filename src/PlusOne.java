import java.util.Stack;

/**
 * Created by Administrator on 2018/10/18.
 */
public class PlusOne {

    public static int[] plusOne1(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i];
            if (i == digits.length - 1) {
                num += flag + 1;
            } else {
                num += flag;
            }
            if (num > 9) {
                stack.push(0);
                flag = 1;
            } else {
                stack.push(num);
                flag = 0;
            }
        }
        if (flag == 1) {
            stack.push(1);
        }
        int[] arrays = new int[stack.size()];
        int j = 0;
        while (!stack.empty()) {
            arrays[j++] = stack.pop();
        }
        return arrays;
    }



    public static void main(String[] args) {
        int[] test = new int[]{9,9};
        System.out.print(plusOne1(test));
    }
}
