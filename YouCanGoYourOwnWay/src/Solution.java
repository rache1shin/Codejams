import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			String p = in.next();
			System.out.print("Case #"+i+": ");
			for(int j=0; j<p.length(); j++)
				System.out.print(p.charAt(j)=='E'?'S':'E');
			System.out.println();
		}
	}
}