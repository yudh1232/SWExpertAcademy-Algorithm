import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] magnet;
	static int[] redArrow;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int k = Integer.parseInt(in.readLine());
			
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			redArrow = new int[] {0, 0, 0, 0};
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				int number = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				spread(number, dir, 0);
			}
			
			int score = getScore();
			
			sb.append("#").append(tc).append(" ").append(score).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 전파하는 함수, dir => 1: 시계방향, -1: 반시계방향, way => 1: 오른쪽, -1: 왼쪽
	private static void spread(int number, int dir, int way) {
		if (way == 0) {
			if (number >= 2 && magnet[number - 1][findRAPos(number, -2)] != magnet[number - 2][findRAPos(number - 1, 2)]) {
				spread(number - 1, -dir, -1);
			}
			if (number <= 3 && magnet[number - 1][findRAPos(number, 2)] != magnet[number][findRAPos(number + 1, -2)]) {
				spread(number + 1, -dir, 1);
			}
		}
		else if (way == -1) {
			if (number >= 2 && magnet[number - 1][findRAPos(number, -2)] != magnet[number - 2][findRAPos(number - 1, 2)]) {
				spread(number - 1, -dir, -1);
			}
		}
		else {
			if (number <= 3 && magnet[number - 1][findRAPos(number, 2)] != magnet[number][findRAPos(number + 1, -2)]) {
				spread(number + 1, -dir, 1);
			}
		}
		
		rotate(number, dir);
	}

	// 빨간 화살표의 위치 반환
	private static int findRAPos(int number, int k) {
		if (redArrow[number - 1] + k < 0)
			return redArrow[number - 1] + k + 8;
		else
			return (redArrow[number - 1] + k) % 8;
	}

	// 자석을 회전하는 함수, dir => 1: 시계방향, -1: 반시계방향
	private static void rotate(int number, int dir) {
		if (dir == 1)
			redArrow[number - 1] = findRAPos(number, -1);
		else
			redArrow[number - 1] = findRAPos(number, 1);
	}
	
	// 점수를 계산하여 반환
	private static int getScore() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (magnet[i][redArrow[i]] == 1) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}
	
}
