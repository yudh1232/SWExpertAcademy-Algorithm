import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int limit;
	static int[] score;
	static int[] cal;
	static boolean[] isSelected;
	static int maxScore;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			score = new int[n];
			cal = new int[n];
			isSelected = new boolean[n];
			maxScore = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			generateSubset(0);
			
			sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static void generateSubset(int cnt) {
		// 부분집합 완성
		if (cnt == n) {
			// 부분집합의 합을 계산
			int scoreSum = 0;
			int calSum = 0;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					scoreSum += score[i];
					calSum += cal[i];
				}
			}
			
			if (calSum <= limit) {
				if (scoreSum > maxScore) {
					maxScore = scoreSum;
				}
			}
			
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}

/* dp 풀이
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[] calories = new int[n + 1];
			int[] scores = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(in.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[n + 1][l + 1];
			for (int i = 1; i <= n; i++) {
				for (int cal = 1; cal <= l; cal++) {
					if (calories[i] <= cal) {
						dp[i][cal] = Math.max(dp[i - 1][cal], scores[i] + dp[i - 1][cal - calories[i]]);
					}
					else {
						dp[i][cal] = dp[i - 1][cal];
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[n][l]).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
*/
