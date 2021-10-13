import java.io.*;
import java.util.*;

public class Solution {

	static int result = 0;
	static int[][] bc;
	static int m, n;
	static int aPosX, aPosY, bPosX, bPosY;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {0, 0, 1, 0, -1};
		int[] dy = {0, -1, 0, 1, 0};
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			int[] routeA = new int[m];
			int[] routeB = new int[m];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < m; i++) {
				routeA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < m; i++) {
				routeB[i] = Integer.parseInt(st.nextToken());
			}
			
			bc = new int[n][4];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Arrays.sort(bc, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[3] - o2[3];
				}				
			});
			
			result = 0;
			
			aPosX = 1;
			aPosY = 1;
			bPosX = 10;
			bPosY = 10;
			charge();
			
			for (int i = 0; i < m; i++) {
				aPosX += dx[routeA[i]];
				aPosY += dy[routeA[i]];
				bPosX += dx[routeB[i]];
				bPosY += dy[routeB[i]];
				
				charge();
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static void charge() {
		List<Integer> accessibleBcA = new ArrayList<Integer>();
		List<Integer> accessibleBcB = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			if (Math.abs(bc[i][0] - aPosX) + Math.abs(bc[i][1] - aPosY) <= bc[i][2]) accessibleBcA.add(i);
			if (Math.abs(bc[i][0] - bPosX) + Math.abs(bc[i][1] - bPosY) <= bc[i][2]) accessibleBcB.add(i);
		}
		
		if (accessibleBcA.size() != 0) {
			result += bc[accessibleBcA.get(accessibleBcA.size() - 1)][3];
		}
		if (accessibleBcB.size() != 0) {
			result += bc[accessibleBcB.get(accessibleBcB.size() - 1)][3];
		}
		if (accessibleBcA.size() != 0 && accessibleBcB.size() != 0 && accessibleBcA.get(accessibleBcA.size() - 1) == accessibleBcB.get(accessibleBcB.size() - 1)) {
			result -= bc[accessibleBcA.get(accessibleBcA.size() - 1)][3];
			result -= bc[accessibleBcB.get(accessibleBcB.size() - 1)][3];
			
			int temp1 = 0;
			int temp2 = 0;
			if (accessibleBcA.size() >= 2) {
				temp1 = bc[accessibleBcA.get(accessibleBcA.size() - 2)][3] + bc[accessibleBcB.get(accessibleBcB.size() - 1)][3];
			}
			if (accessibleBcB.size() >= 2) {
				temp2 = bc[accessibleBcB.get(accessibleBcB.size() - 2)][3] + bc[accessibleBcA.get(accessibleBcA.size() - 1)][3];
			}
			int valueToAdd = Math.max(temp1, temp2);
			valueToAdd = Math.max(valueToAdd, (bc[accessibleBcA.get(accessibleBcA.size() - 1)][3] + bc[accessibleBcB.get(accessibleBcB.size() - 1)][3]) / 2);
			result += valueToAdd;
		}
		
	}
	
}
