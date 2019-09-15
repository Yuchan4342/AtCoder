import java.io.*;
import java.util.*;

public class Main {
	static int[] prices;

	public static void main(String[] args) {
		try {
			BufferedReader br = createBufferedReader();
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			final int N = Integer.parseInt(st.nextToken());
			final int M = Integer.parseInt(st.nextToken());
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			prices = new int[N];
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(prices);
			int[] minprices = discount(prices, M);
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += minprices[i];
			}
			System.out.println(sum);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static int[] discount(final int[] prices, final int times) {
		if (times == 0) {
			return prices;
		}
		int[] newprices = prices;
		int n = newprices.length;
		for (int i = 0; i < times; i++) {
			int index = n - 1;
			if (newprices[index] <= 0) return newprices;
			newprices[index] = newprices[index] / 2;
			// sort
			while (index > 0) {
				if (newprices[index] < newprices[index - 1]){
					int w = newprices[index];
					newprices[index] = newprices[index - 1];
					newprices[index - 1] = w;
				} else {
					break;
				}
				index--;
			}
		}
		return newprices;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		return new BufferedReader(isr);
	}
}
