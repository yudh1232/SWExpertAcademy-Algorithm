import java.io.*;
import java.util.*;

public class Solution {

	static int N, M;
	static long Q = 1000000007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			long result = surjection(M, N, Q);
			result = result >= 0 ? result : (result + Q);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long surjection(int m, int n, long p) {
		long tot = 0L;
		for (int i = 0; i < n; i++) {
			tot = (tot + ((i % 2 == 0 ? 1L : -1L) * (((power(n - i, m, p) % p) * nCr(n, i, p) % p) % p)) % p) % p;
		}
		return tot % p;
	}

	private static long nCr(int n, int r, long p) {
        if (r == 0)
            return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;
        
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;
      
        return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n-r], p) % p) % p;
    }

	private static long modInverse(long n, long p) {
		return power(n, p-2, p);
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
		return res % p;
	}
	
}
