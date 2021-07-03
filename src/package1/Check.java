package package1;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;




public  class Check{
	
//	public Object add() {
////		Object a1=new Object();
////		Object[] ob=new Object[1];
////		ob[0]=a1;
////		a1=null;
////		return ob[0];
//		
//	}
	public static class has extends Thread{
	public has() {
		System.out.println("My Thread");
	}
	public void run() {
		System.out.println("bar");
	}
	public void run(String s) {
	System.out.println("barz");
	}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] arr = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 9, 1 } };
//		System.out.println(fun(arr));'
		
		
//		Object x=new Vector<>().elements();
//		System.out.println((x instanceof Enumeration)+",");
//		System.out.println((x instanceof Iterator)+",");
//		System.out.println((x instanceof ListIterator)+",");
////		System.out.println((x instanceof Enumeration)+",");'
//		Check ch=new Check();
//	Object k=ch.add();
		
//	
		
		
//		
//		try {
//			System.out.println("ff");
//			add();
//			
//		}catch (ArithmeticException e) {
//			
//			System.out.println("csu");
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		finally {
//			System.out.println("final");
//		}
//		System.out.println("after");
		
		Thread t= new has() {
		public void run() {
			System.out.println("foo");
		}
		};
		t.start();

	}

	public static int fun(int[][] arr) {

		HashSet<String> vis = new HashSet<>();
		LinkedList<String> q = new LinkedList<>();
		q.add(0 + "," + 0 + "," + 0);
		int count = 1;
		while (q.size() > 0) {
			int tc = 0;
			while (count > 0) {
				String[] rem = q.removeFirst().split(",");
				count--;
				int i = Integer.parseInt(rem[0]);
				int j = Integer.parseInt(rem[1]);
				int c = Integer.parseInt(rem[2]);

				if (arr[i][j] == 9) {
					return c;
				}
				vis.add(i + "," + j);
				if (isValid(arr, i + 1, j, vis)) {
					String str = (i + 1) + "," + j + "," + (c + 1);
					q.addLast(str);
					tc++;

				}
				if (isValid(arr, i - 1, j, vis)) {
					String str = (i - 1) + "," + j + "," + (c + 1);
					q.addLast(str);
					tc++;

				}
				if (isValid(arr, i, j + 1, vis)) {
					String str = i + "," + (j + 1) + "," + (c + 1);
					q.addLast(str);
					tc++;

				}
				if (isValid(arr, i, j - 1, vis)) {
					String str = i + "," + (j - 1) + "," + (c + 1);
					q.addLast(str);
					tc++;

				}
			}
			count = tc;

		}
		return -1;

	}

	private static boolean isValid(int[][] arr, int i, int j, HashSet<String> vis) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || vis.contains(i + "," + j))
			return false;
		return true;
	}
	
	public static void sum() {
		
		
		
	}
	
	

}
