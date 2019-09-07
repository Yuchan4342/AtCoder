import java.io.*;
import java.util.*;

public class Main {
	static long[] listS, listT;

	public static void main(String[] args) {
		try {
			InputStreamReader isr =new InputStreamReader(System.in);
	   		BufferedReader br =new BufferedReader(isr);
	        String buf = br.readLine();
	        StringTokenizer st = new StringTokenizer(buf," ");
	    	final int a = Integer.parseInt(st.nextToken());
	    	final int b = Integer.parseInt(st.nextToken());
	    	final int q = Integer.parseInt(st.nextToken());
	        if (a < 1 || a > 100000) {
	        	throw new IllegalArgumentException();
	        }
	        if (b < 1 || b > 100000) {
	        	throw new IllegalArgumentException();
	        }
	        if (q < 1 || q > 100000) {
	        	throw new IllegalArgumentException();
	        }
	        listS = new long[a];
	        for (int i = 0; i < a; i++) {
	        	String str = br.readLine();
	        	listS[i] = Long.parseLong(str);
	        	if (listS[i] < 1 || listS[i] > 10000000000L) {
	        		throw new IllegalArgumentException();
	        	}
	        }
	        listT = new long[b];
	        for (int i = 0; i < b; i++) {
	        	String str = br.readLine();
	        	listT[i] = Long.parseLong(str);
	        	if (listT[i] < 1 || listT[i] > 10000000000L) {
	        		throw new IllegalArgumentException();
	        	}
	        }
	        long[] listX = new long[q];
	        for (int i = 0; i < q; i++) {
	        	String str = br.readLine();
	        	listX[i] = Long.parseLong(str);
	        	if (listX[i] < 1 || listX[i] > 10000000000L) {
	        		throw new IllegalArgumentException();
	        	}
	        }
	        for (int i = 0; i < listX.length; i++) {
	        	System.out.println(getMinimumDistance(listX[i]));
	        }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("入力が正しくありません。");
		}
	}

	private static long getMinimumDistance(final long x) {
		long closestShrine = getClosestShrine(x);
		long closestTemple = getClosestTemple(x);
		long a = Math.abs(closestShrine - x) + Math.abs(getClosestTemple(closestShrine) - closestShrine);
		long b = Math.abs(closestTemple - x) + Math.abs(getClosestShrine(closestTemple) - closestTemple);
		return (a <= b) ? a : b;
	}

	private static long getClosestShrine(final long x) {
		long result, result2;
		for (int i = 0; i < listS.length; i++) {
			if (listS[i] > x) {
				result = listS[i] - x;
				if (i != 0) {
					result2 = x - listS[i - 1];
					return (result <= result2) ? listS[i] : listS[i - 1];
				}
				return listS[i];
			}
		}
		return listS[listS.length - 1];
	}

	private static long getClosestTemple(final long x) {
		long result, result2;
		for (int i = 0; i < listT.length; i++) {
			if (listT[i] > x) {
				result = listT[i] - x;
				if (i != 0) {
					result2 = x - listT[i - 1];
					return (result <= result2) ? listT[i] : listT[i - 1];
				}
				return listT[i];
			}
		}
		return listT[listT.length - 1];
	}
}
