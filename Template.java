import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
	   		BufferedReader br = createBufferedReader();
	        String str = br.readLine();
	        StringTokenizer st = new StringTokenizer(str, " ");
	        int input = Integer.parseInt(str);
	       	System.out.println(method(input));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static int method(final int a) {
		return a;
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
