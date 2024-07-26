package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 Example 1:
 Input: arr = [1,0,2,3,0,4,5,0]
 Output: [1,0,0,2,3,0,0,4]
 Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 Example 2:
 Input: arr = [1,2,3]
 Output: [1,2,3]
 Explanation: After calling your function, the input array is modified to: [1,2,3]

 Constraints:
 1 <= arr.length <= 104
 0 <= arr[i] <= 9
 **/
public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int length = arr.length;
        int zeros = 0;

        // First pass: Count the number of zeros
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        // Second pass: Fill the array from the end
        for (int i = length - 1, j = length + zeros - 1; i >= 0; i--) {
            if (j < length) {
                arr[j] = arr[i]; // Shift the element to the right
            }
            if (arr[i] == 0) {
                j--; // Duplicate the zero
                if (j < length) {
                    arr[j] = 0; // Place the duplicate zero
                }
            }
            j--; // Move to the next position
        }
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        // Output the modified array
        System.out.println(Arrays.toString(arr)); // Output: [1, 0, 0, 2, 3, 0, 0, 4]
    }
}
