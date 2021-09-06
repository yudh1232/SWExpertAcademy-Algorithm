import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int maxDumpCnt = Integer.parseInt(in.readLine());
			int[] num = new int[100];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			for (int i = 0; i < 100; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < maxDumpCnt; i++) {
				Arrays.sort(num);
				
				if (num[99] - num[0] <= 1)
					break;
				
				num[99]--;
				num[0]++;				
			}
			
			Arrays.sort(num);			
			int result = num[99] - num[0];
			sb.append(result);
			sb.append("\n");
		}
		
		System.out.println(sb);	
	}
	
}
