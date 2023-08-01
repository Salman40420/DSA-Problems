package BinarySearch;

// Problem: Count Occurrences of an Integer

/**
 *
 * Problem Description
 *    Given a sorted integer array of length n with possible duplicate elements. Find the number of occurrences of an integer k using binary search.
 *
 *    Input format
 *      There are 2 lines of input.
 *      First line contains 2 space separated integers n, k - Number of elements, the integer k.
 *      Second line contains n space separated integers - The integer array.
 *
 *    Output format
 *      Print the number of occurrences of the integer k.
 *
 *    Sample Input 1
 *      5 2
 *      -1 2 2 4 7
 *
 *    Sample Output 1
 *      2
 *
 *
 **/

import java.util.*;

class CountOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int res = countOccurrences(n, k, a);

        System.out.println(res);
    }

    // We can solve this using Linear Search. But it will take O(N). We strictly need to use Binary Search here.
    // EX., [1 1 2 2 2 2 3], target = 2
    //      If we find the first occurrence and the last occurrence of 2 in an array, then we will be able to find
    //      the count.
    //      In the above ex., 2 occurrence at index 2 first and at index 5 last.
    //      If we do, (5 - 2) + 1, then we will get the total count of target 2.
    //
    // T.C.: O(logN) + O(logN) = O(logN)
    // S.C.: O(1)
    static int countOccurrences(int n, int k, int[] a) {

        int l = 0;
        int r = n-1;

        int firstOccur = findFirstOccurrence(a, l, r, k);

        if(firstOccur < 0)
            return 0;

        int lastOccur = findLastOccurrence(a, l, r, k);

        return lastOccur - firstOccur + 1;

    }

    static int findFirstOccurrence(int[] arr, int l, int r, int target) {

        while(l <= r) {

            int mid = (l + r)/2;

            if(arr[mid] == target) {
                if(mid == 0 || arr[mid - 1] < target)
                    return mid;

                if(arr[mid - 1] == target)
                    r = mid-1;
            } else if(arr[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }

    static int findLastOccurrence(int[] arr, int l, int r, int target) {
        int n = arr.length;
        while(l <= r) {

            int mid = (l + r)/2;

            if(arr[mid] == target) {
                if(mid == n-1 || arr[mid + 1] > target)
                    return mid;

                if(arr[mid + 1] == target)
                    l = mid+1;
            } else if(arr[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }
}
