import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++)
                arr[j] = in.nextInt();
            Solution sol = new Solution();
            int index = sol.getErrorIndex(arr);
            if(index == -1)
                System.out.println("Case #" + i + ": OK");
            else
                System.out.println("Case #" + i + ": "+index);
        }
    }
    private int getErrorIndex(int[] arr){
        int[] evenIndexedValues = new int[(arr.length + 1) / 2];
        int[] oddIndexedValues = new int[arr.length / 2];
        for (int i = 0; i < arr.length; i += 2) evenIndexedValues[i / 2] = arr[i];
        for (int i = 1; i < arr.length; i += 2) oddIndexedValues[i / 2] = arr[i];
        Arrays.sort(evenIndexedValues);
        Arrays.sort(oddIndexedValues);
        // Check if the logically reassembled array is sorted
        int last = evenIndexedValues[0];
        for (int i = 1; i < arr.length; i++) {
            int curr = i % 2 == 0 ? evenIndexedValues[i / 2] : oddIndexedValues[i / 2];
            if (curr < last) return i - 1;
            last = curr;
        }
        return -1;
    }
}