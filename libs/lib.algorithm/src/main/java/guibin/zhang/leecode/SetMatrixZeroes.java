package guibin.zhang.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * @author Gubin Zhang <guibin.beijing@gmail.com>
 */
public class SetMatrixZeroes {
    
    /**
     * Run Status: Accepted!
     * Program Runtime: 692 milli secs
     * Progress: 154/154 test cases passed.
     * 
     * Use O(m + n) space
     * 
     * @param matrix 
     */
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        if(rows == 0) return;
        int cols = matrix[0].length;
        Set<Integer> r = new HashSet<Integer>();
        Set<Integer> c = new HashSet<Integer>();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }
        
        for(int i : r) {
            for(int jj = 0; jj < cols; jj++) {
                matrix[i][jj] = 0;
            }
        }
        for(int j : c) {
            for(int ii = 0; ii < rows; ii++) {
                matrix[ii][j] = 0;
            }
        }
    }
    
    /**
     * Since it is required to do in place, so use the element itself to store the status.
     * @param matrix 
     */
    public void setZeroes_v2(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return;
        int cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    for(int jj = 0; jj < cols; jj++) {
                        if(matrix[i][jj] != 0) {
                            matrix[i][jj] = -1;
                        }
                    }
                    for(int ii = 0; ii < rows; ii++) {
                        if(matrix[ii][j] != 0) {
                            matrix[ii][j] = -1;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
