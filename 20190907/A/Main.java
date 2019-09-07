import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr =new InputStreamReader(System.in);
	   		BufferedReader br =new BufferedReader(isr);
	        String dateString = br.readLine();
	       	System.out.println(isHeisei(dateString) ? "Heisei" : "TBD");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static boolean isHeisei(final String dateString) {
		StringTokenizer st = new StringTokenizer(dateString, "/");
		final int y = Integer.parseInt(st.nextToken());
	    final int m = Integer.parseInt(st.nextToken());
	    final int d = Integer.parseInt(st.nextToken());
	    if (m <= 4) {
	    	return true;
	    }
		return false;
	}
}
