package guibin.zhang.leetcode.math;

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * @author Guibin Zhang <guibin.beijing@gmail.com>
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }
}
