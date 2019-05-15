import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			InputStreamReader isr =new InputStreamReader(System.in);
	   		BufferedReader br =new BufferedReader(isr);
	        String str = br.readLine();
	        int input = Integer.parseInt(str);
	       	System.out.println(method(input));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static int method(final int a) {
		return a;
	}
}
