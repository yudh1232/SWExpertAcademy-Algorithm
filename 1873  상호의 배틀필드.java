import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			int x = -1;
			int y = -1;
			int dir = -1;
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String s = in.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					if (dir == -1) {
						if (map[i][j] == '^') {
							x = i;
							y = j;
							dir = 0;
						}
						else if (map[i][j] == 'v') {
							x = i;
							y = j;
							dir = 1;
						}
						else if (map[i][j] == '<') {
							x = i;
							y = j;
							dir = 2;
						}
						else if (map[i][j] == '>') {
							x = i;
							y = j;
							dir = 3;
						}
					}
				}
			}
			
			int n = Integer.parseInt(in.readLine());
			String input = in.readLine();
			
			for (int i = 0; i < n; i++) {
				if (input.charAt(i) == 'U') {
					dir = 0;
					map[x][y] = '^';
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '^';
						x = nx;
						y = ny;
					}
				}
				else if (input.charAt(i) == 'D') {
					dir = 1;
					map[x][y] = 'v';
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = 'v';
						x = nx;
						y = ny;
					}
				}
				else if (input.charAt(i) == 'L') {
					dir = 2;
					map[x][y] = '<';
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '<';
						x = nx;
						y = ny;
					}
				}
				else if (input.charAt(i) == 'R') {
					dir = 3;
					map[x][y] = '>';
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '>';
						x = nx;
						y = ny;
					}
				}
				else if (input.charAt(i) == 'S') {
					int tx = x;
					int ty = y;
					while (true) {
						int nx = tx + dx[dir];
						int ny = ty + dy[dir];
						if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
							break;
						}
						else if (map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;
						}
						else if (map[nx][ny] == '#') {
							break;
						}
						else {
							tx = nx;
							ty = ny;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
}
