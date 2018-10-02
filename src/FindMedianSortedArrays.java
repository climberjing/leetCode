/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p/>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p/>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p/>
 * Example 1:
 * <p/>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p/>
 * The median is 2.0
 * Example 2:
 * <p/>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p/>
 * The median is (2 + 3)/2 = 2.5
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *     left_part          |        right_part
 A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
 */
public class FindMedianSortedArrays {


    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int totalSize = nums1.length + nums2.length;
        int median = totalSize / 2;
        int i = 0, j = 0;
        while (median > 0) {
            if (i < nums1.length && j < nums2.length && nums1[i] <= nums2[j]) {
                result = nums1[i];
                i++;
            } else if (j < nums2.length) {
                result = nums2[j];
                j++;
            } else if(i < nums1.length){
                result = nums1[i];
                i++;
            }
            median--;
        }
        if (totalSize % 2 != 0) {
            if (i < nums1.length && j < nums2.length) {
                return Math.min(nums1[i], nums2[j]);
            } else if (i < nums1.length) {
                return nums1[i];
            } else {
                return nums2[j];
            }
        } else {
            int nextNum;
            if (i < nums1.length && j < nums2.length) {
                nextNum = Math.min(nums1[i], nums2[j]);
            } else if (i < nums1.length) {
                nextNum = nums1[i];
            } else {
                nextNum = nums2[j];
            }
            return (result + nextNum) / 2;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {3,4};
        int[] num2 = {};
        double num = findMedianSortedArrays(num1, num2);
        System.out.println(num);
    }
}
