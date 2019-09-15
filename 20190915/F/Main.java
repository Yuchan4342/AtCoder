import java.io.*;
import java.util.*;

public class Main {
	static long[] listS, listT;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			final int N = Integer.parseInt(line);
			line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static long getMinimumDistance(final long x) {
		long closestShrine = getClosestShrine(x);
		long closestTemple = getClosestTemple(x);
		long a = Math.abs(closestShrine - x) + Math.abs(getClosestTemple(closestShrine) - closestShrine);
		long b = Math.abs(closestTemple - x) + Math.abs(getClosestShrine(closestTemple) - closestTemple);
		return (a <= b) ? a : b;
	}

	private static long getClosestShrine(final long x) {
		long result, result2;
		for (int i = 0; i < listS.length; i++) {
			if (listS[i] > x) {
				result = listS[i] - x;
				if (i != 0) {
					result2 = x - listS[i - 1];
					return (result <= result2) ? listS[i] : listS[i - 1];
				}
				return listS[i];
			}
		}
		return listS[listS.length - 1];
	}

	private static long getClosestTemple(final long x) {
		long result, result2;
		for (int i = 0; i < listT.length; i++) {
			if (listT[i] > x) {
				result = listT[i] - x;
				if (i != 0) {
					result2 = x - listT[i - 1];
					return (result <= result2) ? listT[i] : listT[i - 1];
				}
				return listT[i];
			}
		}
		return listT[listT.length - 1];
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
