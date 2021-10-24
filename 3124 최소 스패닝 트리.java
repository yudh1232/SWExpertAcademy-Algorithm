import java.io.*;
import java.util.*;

public class Solution {

	static class Edge implements Comparable<Edge> {
		
		int start, end, cost;
		
		public Edge(int start, int end, int cost) {
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
	
	static int v;
	static int[] parents;
	
	private static void make() {
		parents = new int[v + 1];

		for (int i = 1; i <= v; i++) {
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
		
		if (aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine());
			v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			Edge[] edgeList = new Edge[e];
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(a, b, c);
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.cost;
					if (++cnt == e - 1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
