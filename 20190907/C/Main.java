import java.io.*;
import java.util.*;

public class Main {
	static int a, b, c;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			final int N = Integer.parseInt(line);
			int[] a = new int[N];
			int[] b = new int[N - 1];
			line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			for (int i = 0; i < N - 1; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			a[0] = b[0];
			int sum = a[0];
			for (int i = 1; i < N - 1; i++) {
				a[i] = min(b[i - 1], b[i]);
				sum += a[i];
			}
			a[N - 1] = b[N - 2];
			sum += a[N - 1];
			System.out.println(sum);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	private static int min(final int a, final int b) {
		return (a < b) ? a : b;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
