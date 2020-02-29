// euclid algorithm to get gcd

import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  
		for (int i = 1; i <= t; ++i) {
			BigInteger N = in.nextBigInteger();
			int L = in.nextInt();
			BigInteger[] input = new BigInteger[L];
			for(int j=0; j<L; j++) {
				input[j] = in.nextBigInteger();
			}
			Solution sol = new Solution();
			System.out.println("Case #" + i + ": " + sol.deCipher(N,L,input));
		}
	}
	private String deCipher(BigInteger N, int L, BigInteger[] input) {
		String res = "";
		BigInteger[] msg = new BigInteger[L+1];
		HashMap<BigInteger, Character> alphabetMap = new HashMap<>();

		int index;
		for(index = 1; index<L; index++) {
			BigInteger gcd = BigInteger.ZERO;
			if(!input[index-1].equals(input[index])) {
				gcd = getGcd(N, input[index-1], input[index]);
				if(gcd != BigInteger.ONE) {
					msg[index]=gcd;
					break;
				}
			}
		}
		//forward
		for(int i = index+1; i<L+1; i++) {
			msg[i] = input[i-1].divide(msg[i-1]);
		}
		//backward
		for(int j=index; j>0; j--) {
			msg[j-1] = input[j-1].divide(msg[j]);
		}

		BigInteger[] keys = Arrays.copyOf(msg, L+1);
		Arrays.parallelSort(keys);

		//make map
		Character c = 'A';
		for(int i=0; i<L+1; i++) {
			if(!alphabetMap.containsKey(keys[i])) {
				alphabetMap.put(keys[i], c);
				c = (char) (c+1);
			}
		}

		//get result
		for(int i=0; i<L+1; i++) {
			res += alphabetMap.get(msg[i]);
		}
		return res;
	}
	private BigInteger getGcd(BigInteger N, BigInteger a, BigInteger b) {
		BigInteger big,small;
		BigInteger res = BigInteger.ONE;

		if(a.compareTo(b)==1) {
			big = a;
			small = b;
		}else {
			big = b;
			small = a;
		}

		while(!res.equals(BigInteger.ZERO)) {
			res =big.mod(small);
			big = small;
			small = res;
		}
		if(big.compareTo(N)==1)
			return BigInteger.ONE;
		return big;
	}
}