import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStreamReader isr;
		BufferedReader br;
		try {
			isr = new InputStreamReader(System.in);
	   		br = new BufferedReader(isr);
	        String nstr = br.readLine();
	    	final int n = Integer.parseInt(nstr);
	        if (n < 2 || n > 10) {
	        	throw new IllegalArgumentException();
	        }
	        double sum = 0;
	        for (int i = 0; i < n; i++) {
	        	String str = br.readLine();
	        	StringTokenizer st = new StringTokenizer(str, " ");
	        	double amount = Double.parseDouble(st.nextToken());
	        	String unit = st.nextToken();
	        	if (!unit.equals("JPY") && !unit.equals("BTC")) {
	        		throw new IllegalArgumentException();
	        	}
	        	sum += unit.equals("JPY") ? amount : getJPY(amount);
	        }
	        System.out.println(sum);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	private static double getJPY(final double amount) {
		final double rate = 380000.0;
		return rate * amount;
	}
}
