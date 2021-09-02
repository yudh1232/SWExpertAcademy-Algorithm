import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input1204.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int[] counts = new int[101];
			
			int n = Integer.parseInt(in.readLine());
			
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data, " ");
			
			for (int i = 0; i < 1000; i++) {
				counts[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = -1;
			int idx = -1;
			for (int i = 0; i <= 100; i++) {
				if (counts[i] >= max) {
					max = counts[i];
					idx = i;
				}
			}
			
			System.out.println("#" + n + " " + idx);
		}		
		
	}
	
}
