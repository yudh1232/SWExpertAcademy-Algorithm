import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			if (n == 1) {
				sb.append(st.nextToken()).append("\n");
			}
			else {
				String[] up = new String[(n + 1) / 2];
				String[] down = new String[n / 2];
				
				for (int i = 0; i < (n + 1) / 2; i++) {
					up[i] = st.nextToken();
				}
				
				for (int i = 0; i < n - (n + 1) / 2; i++) {
					down[i] = st.nextToken();
				}
				
				int idx = 0;
				int count = 0;
				while (true) {
					if (count == n) break;
					sb.append(up[idx]).append(" ");
					count++;
					
					if (count == n) break;
					sb.append(down[idx]).append(" ");
					count++;
					
					idx++;
				}
				
				sb.setLength(sb.length() - 1);
				sb.append("\n");
				
			}
			
		}
		
		System.out.println(sb);

	}
	
}
