import java.io.*;
import java.util.*;

public class Solution {

	static class Edge implements Comparable<Edge> {
		
		int start, end;
		double cost;
		
		public Edge(int start, int end, double cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost) return -1;
			return 1;
		}	
		
	}
	
	static int n;
	static int[] parents;
	
	private static void make() {
		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input1251.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			n = Integer.parseInt(in.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double e = Double.parseDouble(in.readLine());
			
			Edge[] edgeList = new Edge[n * (n - 1) / 2];
			
			int edgeCnt = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					edgeList[edgeCnt++] = new Edge(i, j, Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2));
				}
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			double result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.cost;
					if (++cnt == n - 1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(result * e)).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
