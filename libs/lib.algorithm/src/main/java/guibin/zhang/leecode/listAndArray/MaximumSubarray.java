package guibin.zhang.leecode.listAndArray;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * 
 * Run Status: Accepted!
 * Program Runtime: 528 milli secs
 * Progress: 200/200 test cases passed.
 * 
 * @author Gubin Zhang <guibin.beijing@gmail.com>
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }

        int max = A[0];

        int sum = 0;
        for (int i = 0; i < A.length; i++) {

            sum += A[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
