import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
	   		BufferedReader br = createBufferedReader();
	        String str = br.readLine();
	        StringTokenizer st = new StringTokenizer(str);
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        long x = Long.parseLong(st.nextToken());
	       	System.out.println(result(a, b, x));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static long result(final int a, final int b, final long x) {
		int max = 1_000_000_000;
		int digit = String.valueOf(max).length();
		long price = (long)a * max + (long)b * digit;
		if (price <= x) return max;
		int min = 0;
		int half = (max - min) / 2 + min;
		while (max - min > 1) {
			digit = String.valueOf(half).length();
			price = (long)a * half + (long)b * digit;
			if (price > x) {
				max = half;
				half = (max - min) / 2 + min;
			} else if (price < x) {
				min = half;
				half = (max - min) / 2 + min;
			} else {
				return half;
			}
		}
		return min;
	}

	// private static long result(final int a, final int b, final long x) {
	// 	// n <= (x - b * digit) / a <= (x - b) / a + 1
	// 	long n = (x - b) / a + 1;
	// 	int digit = String.valueOf(n).length();
	// 	n = (x - b * n) / a + 1;
	// 	while (n > 0) {
	// 		digit = String.valueOf(n).length();
	// 		long price = (long)a * (long)n + (long)b * digit;
	// 		if (price <= x) {
	// 			return n > 1_000_000_000 ? 1_000_000_000 : n;
	// 		}
	// 		n--;
	// 	}
	// 	return 0;
	// }

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
