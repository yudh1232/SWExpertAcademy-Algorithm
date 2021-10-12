import java.io.*;
import java.util.*;

public class Solution {

	static int[] myCard;
	static int[] opponentCard;
	static int[] numbers;
	static int winCount;
	static int loseCount;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			myCard = new int[9];
			for (int i = 0; i < 9; i++) {
				myCard[i] = Integer.parseInt(st.nextToken());
			}
			
			opponentCard = new int[9];
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				int flag = 1;
				for (int j = 0; j < 9; j++) {
					if (i == myCard[j]) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					opponentCard[index] = i;
					index++;
				}
			}
			
			numbers = new int[9];
			winCount = 0;
			loseCount = 0;
			permutation(0, 0);
			
			sb.append("#").append(tc).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void permutation(int cnt, int flag) {
		if (cnt == 9) {
			int myScore = 0;
			int oppoScore = 0;
			for (int i = 0; i < 9; i++) {
				if (myCard[i] > numbers[i]) {
					myScore = myScore + myCard[i] + numbers[i];
				}
				else {
					oppoScore = oppoScore + myCard[i] + numbers[i];
				}
			}
			
			if (myScore > oppoScore) winCount++;
			else if (myScore < oppoScore) loseCount++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			numbers[cnt] = opponentCard[i];
			permutation(cnt + 1, flag | 1<<i);
		}
	}
}
