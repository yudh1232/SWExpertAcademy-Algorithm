import java.io.*;
import java.util.*;

public class Solution {

	static int[] parents;
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			make();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			for (int i = 1; i <= n; i++) {
				find(i);
			}
			
			boolean[] root = new boolean[n + 1];
			
			for (int i = 1; i <= n; i++) {
				root[parents[i]] = true;
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (root[i] == true) count++;
			}
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void make() {
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
	
}
