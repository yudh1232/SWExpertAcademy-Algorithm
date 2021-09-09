import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			// 큐에 8개 숫자 넣기
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int decrease = 1; // 감소할 양 (1 ~ 5 싸이클)
			while (true) {
				// 큐에서 숫자 하나 꺼내고 감소할 양만큼 감소시킴
				int now = q.poll();
				now = now - decrease;
				
				// 감소한 값이 0이하일 경우 0으로 바꾸어서 큐에 넣고 반복 종료
				if (now <= 0) {
					now = 0;
					q.offer(now);
					break;
				}
				// 감소한 값이 0보다 큰 경우 큐에 넣고, 감소할 양을 업데이트
				else {
					q.offer(now);
					decrease++;
					if (decrease == 6) decrease = 1;
				}
			}
			
			sb.append("#").append(n).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.setLength(sb.length() - 1); // 맨뒤 공백 제거
			sb.append("\n");
		}
		
		System.out.println(sb); // 결과 출력
		
	}
	
}
