import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
	   		BufferedReader br = createBufferedReader();
	        String line = br.readLine();
	       	System.out.println(method(line));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static int method(final String str) {
		String[] strings = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		for (int i = 0; i < strings.length; i++) {
			if (str.equals(strings[i])) {
				return 7 - i;
			}
		}
		return -1;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
