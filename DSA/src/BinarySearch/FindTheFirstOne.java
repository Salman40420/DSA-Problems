
/**
        Problem Description
                Given a sorted array consisting of 0s and 1s only, find the index of the first 1. If there’s no 1 present in the array, return -1

         Input format
                 There are 2 lines of input
                 First line will contain a single integer n.
                 Next line will contain n space separated integers.

         Output format
                 Print the index of first occuring if present, otherwise print -1.

         Sample Input 1
                 4
                 0 0 1 1

         Sample Output 1
                 2
 */

package BinarySearch;

import java.util.*;

public class FindTheFirstOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = zeroOnes(n, a);
        System.out.println(res);

    }

    /**
     *
    // Time: O(logN)
    static int zeroOnes(int n, int a[]) {

        int l = 0;
        int r = n-1;

        while(l <= r) {
            int mid = (l + r)/2;

            // Solution 1
            //
            // It has more if statement.
            //
            // if(a[mid] == 0) {
            //     l = mid+1;
            // } else {
            //     if(mid == 0)
            //         return 0;
            //     if(a[mid - 1] == 0) {
            //         return mid;
            //     } else {
            //         r = mid - 1;
            //     }
            // }

            // Solution 2
            //
            // It has less conditional statement.
            //
            if(a[mid] == 1 && (mid == 0 || a[mid-1] == 0)) {
                return mid;
            } else if(a[mid] == 1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
     */


    // Solution 3
    // Time: O(logN)
    static int zeroOnes(int n, int[] a) {

        int l = 0;
        int r = n-1;

        int res = -1;

        while(l <= r) {
            int mid = (l + r)/2;

            if(a[mid] == 1) {
                res = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
