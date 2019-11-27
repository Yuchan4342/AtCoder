import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
	   		BufferedReader br = createBufferedReader();
	   		int n = Integer.parseInt(br.readLine());
	        String str = br.readLine();
	       	System.out.println(rot(n, str));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static String rot(final int n, final String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char c = (char)((str.charAt(i) + n - 'A') % 26 + 'A');
			res = res + String.valueOf(c);
		}
		return res;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
