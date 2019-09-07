import java.io.*;
import java.util.*;

public class C {
	static int a, b, c;

	public static void main(String[] args) {
		try{
			InputStreamReader isr =new InputStreamReader(System.in);
	   		BufferedReader br =new BufferedReader(isr);
	        String buf = br.readLine();
	        StringTokenizer st = new StringTokenizer(buf," ");
	    	final int n = Integer.parseInt(st.nextToken());
	    	a = Integer.parseInt(st.nextToken());
	    	b = Integer.parseInt(st.nextToken());
	    	c = Integer.parseInt(st.nextToken());
	        if (n < 3 || n > 8) {
	        	throw new IllegalArgumentException();
	        }
	        if (a < 1 || a > 1000) {
	        	throw new IllegalArgumentException();
	        }
	        if (b < 1 || b > 1000 || b >= a) {
	        	throw new IllegalArgumentException();
	        }
	        if (c < 1 || c > 1000 || c >= b) {
	        	throw new IllegalArgumentException();
	        }
	        int[] lengths = new int[n];
	        for (int i = 0; i < n; i++) {
	        	String str = br.readLine();
	        	lengths[i] = Integer.parseInt(str);
	        	if (lengths[i] < 1 || lengths[i] > 1000) {
	        		throw new IllegalArgumentException();
	        	}
	        }
	        if (isCompleted(lengths)) {
	        	System.out.println(0);
	        }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	private static boolean isCompleted(final int[] lengths) {
		int ai = -1, bi = -1, ci = -1;
		for (int i = 0; i < lengths.length; i++) {
			if (lengths[i] == a && ai == -1) {
				ai = i;
			} else if (lengths[i] == b && bi == -1) {
				bi = i;
			} else if (lengths[i] == c && ci == -1) {
				ci = i;
			}
		}
		return (ai != -1 && bi != -1 && ci != -1);
	}
}
