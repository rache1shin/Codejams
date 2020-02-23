import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String N = in.next();
			String [] pair = getPair(N);
			System.out.println("Case #" + i + ": "+pair[0]+" "+pair[1]);
		}
	}
	public static String[] getPair(String N) {
		String[] pair = new String[2];
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		boolean bStart = false;
		for(int i=0; i<N.length(); i++) {
			if(N.charAt(i)=='4') {
				a.append('3');
				b.append('1');
				bStart = true;
			}
			else {
				if(bStart)
					b.append('0');
				a.append(N.charAt(i));
			}
		}
		pair[0] = a.toString();
		pair[1] = b.toString();
		return pair;
	}
	
}
