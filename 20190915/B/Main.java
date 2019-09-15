import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStreamReader isr;
		BufferedReader br;
		try {
	   		br = createBufferedReader();
	        String line = br.readLine();
	    	final int n = Integer.parseInt(line);
	        if (n < 2 || n > 20) {
	        	throw new IllegalArgumentException();
	        }
	        int[] a = new int[n];
	        int[] b = new int[n];
	        int[] c = new int[n - 1];
	        line = br.readLine();
	        StringTokenizer st = new StringTokenizer(line, " ");
	        for (int i = 0; i < n; i++) {
	        	a[i] = Integer.parseInt(st.nextToken());
	        }
	        line = br.readLine();
	        st = new StringTokenizer(line, " ");
	        for (int i = 0; i < n; i++) {
	        	b[i] = Integer.parseInt(st.nextToken());
	        }
	        line = br.readLine();
	        st = new StringTokenizer(line, " ");
	        for (int i = 0; i < n - 1; i++) {
	        	c[i] = Integer.parseInt(st.nextToken());
	        }
	        int result = 0;
	        for (int i = 0; i < n; i++) {
	        	result += b[a[i] - 1];
	        	if (i > 0 && a[i] - a[i - 1] == 1) {
	        		result += c[a[i] - 2];
	        	}
	        }
	        System.out.println(result);
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
