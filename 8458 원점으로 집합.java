import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			long[] group = new long[n];
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				group[count++] = Math.abs(a) + Math.abs(b);
			}
			
			boolean isOdd = false;
			boolean isEven = false;
			for (int i = 0; i < n; i++) {
				if (group[i] % 2 == 0) isEven = true;
				else isOdd = true;
			}
			
			long result = 0;
			if (isOdd & isEven) result = -1;
			else {
				Arrays.sort(group);
				long k = 0;
				while (k * (k + 1) / 2 <= group[n - 1]) {
					k++;
				}
				long gap = group[n - 1] - (k - 1) * k / 2;
				if (gap == 0) {
					result = k - 1;
				}
				else {
					if (gap % 2 == k % 2) result = k;
					else if (gap % 2 == 0) result = k + 2;
					else result = k + 1;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
