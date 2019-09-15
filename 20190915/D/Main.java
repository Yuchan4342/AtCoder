import java.io.*;
import java.util.*;

public class Main {
	static long[] listS, listT;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			final int n = Integer.parseInt(st.nextToken());
			final int k = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			int max = numberOfHappy(s);
			for (int i = 0; i < k; i++) {
				String maxS = "";
				for (int l = 0; l < n; l++) {
					for (int r = l; r < n; r++) {
						String changed = changeString(s, l, r);
						int happy = numberOfHappy(changed);
						if (happy > max) {
							maxS = changed;
							max = happy;
						}
					}
				}
				if (maxS.equals("")) {
					break;
				}
				s = maxS;
			}
			System.out.println(max);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	private static int numberOfHappy(final String s) {
		int result = 0, n = s.length();
		for (int i = 0; i < n; i++) {
			if (i != n - 1 && s.charAt(i) == 'R' && s.charAt(i + 1) == 'R') {
				result++;
			} else if (i != 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L') {
				result++;
			}
			s.charAt(i);
		}
		return result;
	}

	private static String changeString(final String s, final int l, final int r) {
		char[] changedStr = s.toCharArray();
		int n = s.length();
		if (l == r) {
			changedStr[l] = changeChar(changedStr[l]);
			return new String(changedStr);
		}
		for (int i = 0; i <= r - l; i++) {
			if (l + i > r - i) {
				break;
			}
			char left = changedStr[l + i];
			char right = changedStr[r - i];
			changedStr[l + i] = changeChar(right);
			changedStr[r - i] = changeChar(left);
		}
		return new String(changedStr);
	}

	private static char changeChar(final char c) {
		if (c == 'L') {
			return 'R';
		}
		if (c == 'R') {
			return 'L';
		}
		return ' ';
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
