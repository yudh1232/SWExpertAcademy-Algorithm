import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			boolean flag = true;
			
			int n = Integer.parseInt(in.readLine());
			if (n == 1 || n % 2 == 0) flag = false;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				if (flag == true) {
					int count = st.countTokens();
					st.nextToken(); // 정점번호 떼어내기
					char data = st.nextToken().charAt(0);
					if (data == '+' || data == '-' || data == '*' || data == '/') {
						if (count != 4) flag = false;
					}
					else {
						if (count != 2) flag = false;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if (flag == true) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
