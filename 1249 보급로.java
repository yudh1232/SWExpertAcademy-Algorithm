import java.io.*;
import java.util.*;

public class Solution {

	// x, y, distance를 담는 클래스 생성
	static class Node implements Comparable<Node> {
		int x, y;
		int distance;
			
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
			
		// distance를 기준으로 sort할 예정
		@Override
		public int compareTo(Node other) {
			if (this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}
		
	// 무한으로 10억을 설정
	static final int INF = (int) 1e9;
	
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수를 입력받음
		int TC = Integer.parseInt(in.readLine());
		
		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= TC; tc++) {
			// n을 입력받고 2차원 배열 map을 입력받음
			int n = Integer.parseInt(in.readLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = in.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			// distance 2차원배열 생성, distance[0][0]은 map[0][0]으로 초기화
			int distance[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(distance[i], INF);
			}
			distance[0][0] = map[0][0];
			
			// 우선순위큐 생성, 첫 노드를 넣음
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, distance[0][0]));
			
			// 다익스트라
			while (!pq.isEmpty()) {
				// 노드를 하나 꺼냄
				Node now = pq.poll();
				int x = now.x;
				int y = now.y;
				int dist = now.distance;
				
				// 이미 처리된 노드면 패스
				if (dist > distance[x][y]) continue;
				
				// 상하좌우로 다음노드 탐색
				for (int d = 0; d < 4; d++) {
					// 다음노드의 좌표, 배열을 벗어나면 패스
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					// 다음노드의 비용 계산
					int cost = dist + map[nx][ny];
					// 계산된 비용이 distance 배열보다 작으면 업데이트하고 큐에 넣음
					if (cost < distance[nx][ny]) {
						distance[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			
			// 출력문 생성
			sb.append("#").append(tc).append(" ").append(distance[n - 1][n - 1]).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}
