import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			int sequence[] = new int[n];
			int lis[] = new int[n];
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				sequence[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (sequence[j] < sequence[i] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
				if (max < lis[i]) max = lis[i];
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
