import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			long result = 0L;
			
			result = calc(b) - calc(a - 1);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long calc(long n) {
		long temp = n;
		long res = 0;
		int count = 0;
		while (temp >= 10) {
			long q = temp / 10;
			long r = temp % 10;
			res += (long) (45 * q * Math.pow(10, count));
			
			if (count == 0) {
				res += r * (r + 1) / 2;
			}
			else {
				res += (long) ((r - 1) * r / 2 * Math.pow(10, count));
				res += (long) (r * (n % Math.pow(10, count) + 1));
			}
			temp /= 10;
			count++;
		}
		
		res += (long) ((temp - 1) * temp / 2 * Math.pow(10, count));
		res += (long) (temp * (n % Math.pow(10, count) + 1));
		
		return res;
	}
	
}
