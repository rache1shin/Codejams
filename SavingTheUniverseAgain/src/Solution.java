import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.		
		for (int i = 1; i <= t; ++i) {
			long limit = in.nextInt();
			String attack = in.next();
			int num;
			if(attack.length()==0) 
				num = -1;
			else
				num = runProgram(limit, attack);	
			if(num==-1) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
			else {
				System.out.println("Case #"+i+": "+num);
			}
		}
	}
	private static int runProgram(long limit, String attack) {
		int[] arr = new int[30];
		int pointer = 0;
		int realPointer=0;
		int change = 0;
		for(int i=0; i<attack.length(); i++) {
			if(attack.charAt(i) == 'S') {arr[pointer] += 1; realPointer=pointer;}
			else {pointer++;}
		}
		pointer = realPointer;
		while(pointer>0) {
			int sum = getSum(arr, pointer);
			if(sum<=limit) {
				return change;
			}
			else if(sum>limit) {
				if(arr[pointer] > 1) {
					arr[pointer]--;
					arr[pointer-1]++;
				}
				else if(arr[pointer] <= 1) {
					pointer--;
					arr[pointer]++;
				}
				change++;
			}
		}
		if(getSum(arr,0)>limit)
			return -1;
		return change;
	}
	private static int getSum(int[] arr, int pointer) {
		int sum = 0;
		for(int i=0; i<=pointer; i++) {
			sum += arr[i] * Math.pow(2, i);
		}
		return sum;
	}
	
} 