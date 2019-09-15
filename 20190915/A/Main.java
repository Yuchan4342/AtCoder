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

	private static String method(final String str) {
		if (str.equals("Sunny")) {
			return "Cloudy";
		} else if (str.equals("Cloudy")) {
			return "Rainy";
		} else if (str.equals("Rainy")) {
			return "Sunny";
		}
		return "";
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
