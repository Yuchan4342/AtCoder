import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStreamReader isr;
		BufferedReader br;
		try {
	   		br = createBufferedReader();
	        String line = br.readLine();
	        char[] arr = line.toCharArray();
	        String res = "Yes";
	        for (int i = 0; i < arr.length; i++) {
	        	if (i % 2 == 0 && arr[i] == 'L') {
	        		res = "No";
	        		break;
	        	}
	        	if (i % 2 == 1 && arr[i] == 'R') {
	        		res = "No";
	        		break;
	        	}
	        }
	        System.out.println(res);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	// 以下問題問わずに共通部分
	// 標準入力の BufferedReader を返す.
	private static BufferedReader createBufferedReader() {
		InputStreamReader isr =new InputStreamReader(System.in);
	   	return new BufferedReader(isr);
	}
}
