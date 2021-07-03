package package1;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(sol(9, 4, 4, 4, 8,new boolean[9][9]));
//		Long h=Instant.now().plus(10,ChronoUnit.YEARS).getEpochSecond();
//		System.out.println(h);
		
		
//		Calendar cal=Calendar.getInstance();
//		cal.add(Calendar.MONTH,120);
//		System.out.println(cal.getTime());
//		Calendar cal1=Calendar.getInstance();
//		cal1.add(Calendar.YEAR, 11);
//		System.out.println(cal.compareTo(cal1));
		
//		Calendar ti=Calendar.getInstance();
//		ti.add(Calendar.DATE, 1);
//		Long ts=ti.getTimeInMillis();
//		cal.setTimeInMillis(ts);
//		System.out.println(cal.getTime());
//		System.out.println(cal.compareTo(ti));
		Map<String,Integer> hm=new HashMap<>();
		String str="8m y 6 M 8";
		List<String> l=Arrays.asList(str.split(" "));
		Iterator<String> it =l.iterator();
		while(it.hasNext()) {
			try {
				int val=Integer.parseInt(it.next());
				String x=it.next();
				System.out.println(val);
				System.out.println(x);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getStackTrace());
			}
			catch (NoSuchElementException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
		}
//		String[] val=str.split(" ");
//		for(int i=1;i<val.length;i=i+2) {
//			hm.put(val[i].toUpperCase(), Integer.parseInt(val[i-1]));
//		}
//		Iterator<String> =
//		Lists.charactersOf(str)    // List<Characters>
//        .listIterator()    // or `iterator()`
//        .forEachRemaining(System.out::print);
//		System.out.println(l);
//		 str.chars()
//         .mapToObj(i -> Character.valueOf((char) i))
//         .forEach(System.out::print);
		
		
		

	}

	/*
	 * public static void fun(String test, String[] arr) {
	 * 
	 * HashMap<Integer, String> hm = new HashMap<>(); HashMap<Character, Integer> h
	 * = new HashMap<>(); for (char c : test.toCharArray()) { h.put(c,
	 * h.getOrDefault(c, 0) + 1); } for(Character c:h.keySet()) { int key=h.get(c);
	 * hm.put(key, ); }
	 */

	public static int sol(int n, int sr, int sc, int er, int ec, boolean[][] vis) {

		pair p = new pair(sr, sc);
		int c = 0;

		LinkedList<pair> q = new LinkedList<>();
		q.add(p);
		while (q.size() > 0) {

			int siz = q.size();
			c++;

			while (siz > 0) {
				pair rem = q.removeFirst();

				siz--;
				int i = rem.r;
				int j = rem.c;
				vis[i][j] = true;
				if (i == er && j == ec)
					return c - 1;
				for (int[] dir : dirs) {
					int di = i + dir[0];
					int dj = j + dir[1];
					if (isValid(n, di, dj, vis)) {
						q.addLast(new pair(di, dj));
					}
				}

			}

		}
		return -1;

	}

	public static class pair {

		int r;
		int c;

		public pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static boolean isValid(int n, int r, int c, boolean[][] vis) {
		if (r < 0 || c < 0 || r >= n || c >= n || vis[r][c])
			return false;
		return true;

	}

	static int[][] dirs = { { 2, 1 }, { 1, 2 }, { -1, -2 }, { -2, -1 }, { -1, 2 }, { -2, 1 }, { 1, -2 }, { 2, -1 } };

}
