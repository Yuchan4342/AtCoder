import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) {
		try{
			InputStreamReader isr =new InputStreamReader(System.in);
	   		BufferedReader br =new BufferedReader(isr);
	        String buf = br.readLine();
	        StringTokenizer st = new StringTokenizer(buf," ");
	    	final int n = Integer.parseInt(st.nextToken());
	        final int m = Integer.parseInt(st.nextToken());
	        if (n < 1 || m < 1 || m > 100000 || m > 100000) {
	        	throw new IllegalArgumentException();
	        }
	        String s = br.readLine();
	        String t = br.readLine();
	        if (s.length() != n || t.length() != m) {
	        	throw new IllegalArgumentException();
	        }
	        if (!isExistGoodString(s, t)) {
	        	System.out.println(-1);
	        	return;
	        }
	        // max: 最大公約数
			int max = 1;
			int i = (n <= m) ? n : m;
			while (i > 1) {
				if (n % i == 0 && m % i == 0) {
					max = i;
					break;
				}
				i--;
			}
	        // min: n, m のどちらでも割り切れる最小の数(最小公倍数)
	        int min = (n / max) * (m / max) * max;
	        System.out.println(min);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.err.println("1 ≦ N, M ≦ 10^5 を満たす必要があります。");
		}
	}

	private static boolean isExistGoodString(final String s, final String t) {
		int n = s.length();
		int m = t.length();
		if (s.charAt(0) != t.charAt(0)) {
			return false;
		}
		// 最大公約数
		int max = 1;
		int i = (n <= m) ? n : m;
		while (i > 1) {
			if (n % i == 0 && m % i == 0) {
				max = i;
				break;
			}
			i--;
		}
		if (max != 1) {
			int a = n / max;
			int b = m / max;
			i = 1;
			while (i * a < n && i * b < m) {
				if (s.charAt(i * a) != t.charAt(i * b)) {
					return false;
				}
				i++;
			}
		}
		return true;
	}

	private static boolean isExistGoodString(final int i, final String s, final String t) throws IllegalArgumentException {
		if (i < 1) {
	        throw new IllegalArgumentException();
	    }
		char[] x = new char[i];
		int j = 0;
		int n = s.length();
		int m = t.length();
		while (j < i) {
			x[j] = '0';
			j++;
		}
		j = 0;
		while (j < n) {
			x[i / n * j] = s.charAt(j);
			j++;
		}
		j = 0;
		while (j < m) {
			if (x[i / m * j] == '0') {
				x[i / m * j] = t.charAt(j);
			} else if (x[i / m * j] != t.charAt(j)) {
				return false;
			}
			j++;
		}
		return true;
	}
}
