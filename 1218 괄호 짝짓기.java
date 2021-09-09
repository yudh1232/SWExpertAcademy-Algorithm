import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[] open = new int[4]; // '(', '[', '{', '<'의 개수를 담는 배열
			int[] close = new int[4]; // ')', ']', '}', '>'의 개수를 담는 배열
			
			int result = 1; // 유효성 여부 변수
			int flag = 0; // 닫는 괄호가 여는 괄호보다 먼저 나왔는지 나타내는 플래그

			String s = in.readLine();
			// 괄호 하나하나를 읽고 각 괄호의 개수를 더함
			for (int i = 0; i < s.length(); i++) {
				// 닫는 괄호가 여는 괄호보다 먼저 나왔으면, 더이상 확인하지 않고 바로 종료
				if (flag == 1) break;
				
				if (s.charAt(i) == '(') {
					open[0]++;
				}
				else if (s.charAt(i) == '[') {
					open[1]++;
				}
				else if (s.charAt(i) == '{') {
					open[2]++;
				}
				else if (s.charAt(i) == '<') {
					open[3]++;
				}
				else if (s.charAt(i) == ')') {
					close[0]++;
				}
				else if (s.charAt(i) == ']') {
					close[1]++;
				}
				else if (s.charAt(i) == '}') {
					close[2]++;
				}
				else if (s.charAt(i) == '>') {
					close[3]++;
				}
				
				// 닫는 괄호가 여는 괄호보다 먼저 나왔는지 체크
				for (int j = 0; j < 4; j++) {
					if (open[j] < close[j]) {
						result = 0;
						flag = 1;
						break;
					}
				}
				
			}
			
			// 괄호의 짝이 맞는지 체크
			if (result != 0) {
				for (int i = 0; i < 4; i++) {
					// 괄호의 짝이 안 맞는다면
					if (open[i] != close[i]) result = 0;
				}
			}
			
			// 출력 문자열 생성
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		// 결과 출력
		System.out.println(sb);
		
	}

}
