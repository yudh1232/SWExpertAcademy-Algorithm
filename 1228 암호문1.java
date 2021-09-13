import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			ArrayList<String> pw = new ArrayList<String>();
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				pw.add(st.nextToken());
			}
			int m = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < m; i++) {
				String c = st.nextToken(); // I 떼어냄
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					pw.add(x + j, st.nextToken());
				}				
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(pw.get(i)).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
