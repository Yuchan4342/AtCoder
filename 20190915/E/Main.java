import java.io.*;
import java.util.*;

public class Main {
	static int[] p;
	static int[][] memo;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			int N = Integer.parseInt(line);
			line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			memo = new int[N][N];
			for (int l = 0; l < N - 1; l++) {
				for (int r = l + 1; r < N; r++) {
					memo[l][r] = -1;
				}
			}
			int result = 0;
			for (int l = 0; l < N - 1; l++) {
				for (int r = N - 1; r > l; r--) {
					result += secondMax(l, r);
				}
			}
			System.out.println(result);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}

	}

	private static int secondMax(final int l, final int r) {
		if (memo[l][r] != -1) {
			return memo[l][r];
		}
		int max = 0, second = 0;
		int maxi = -1, secondi = -1;
		for (int i = l; i <= r; i++) {
			if (p[i] > max) {
				second = max;
				secondi = maxi;
				max = p[i];
				maxi = i;
			} else if (p[i] > second) {
				second = p[i];
				secondi = i;
			}
		}
		memo[l][r] = second;
		int min_i = min(secondi, maxi);
		int max_i = max(secondi, maxi);
		for (int i = l; i <= min_i; i++) {
			for (int j = r; j >= max_i; j--) {
				memo[i][j] = second;
			}
		}
		return second;
	}

	private static int min(final int a, final int b) {
		return (a < b) ? a : b;
	}

	private static int max(final int a, final int b) {
		return (a > b) ? a : b;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
