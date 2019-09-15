import java.io.*;
import java.util.*;

public class Main {
	static int a, b, c;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			final int N = Integer.parseInt(st.nextToken());
			final int K = Integer.parseInt(st.nextToken());
			final int Q = Integer.parseInt(st.nextToken());
			int[] a = new int[Q];
			int[] points = new int[N];
			int maxpoint = 0;
			for (int i = 0; i < N; i++) {
				points[i] = 0;
			}
			for (int i = 0; i < Q; i++) {
				a[i] = Integer.parseInt(br.readLine());
				if (points[a[i] - 1] == maxpoint) {
					maxpoint++;
				}
				points[a[i] - 1]++;
			}
			for (int i = 0; i < N; i++) {
				System.out.println((Q - points[i] < K) ? "Yes" : "No");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
