package package1;

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println(102213);
		System.out.println("10");

		int a = 5;
		long b = a;
		int c = (int) b;
		int k = 10 * 2 / 4;
		System.out.println(k);

		System.out.println(2 ^ 3);

		double pow = Math.pow(10, 2);
		System.out.println(pow);
		double z = ((6.0 * 1.0) / 5.0);
		System.out.println(z);

//		System.out.println(Byte.MIN_VALUE);
		int[] arr = { 10, 20, 30 };
		for (int i = 0; i < 3; i++) {
			String str = "";
			for (int j = i; j < 3; j++) {
				str += arr[j];
				System.out.println(str);

			}
		}

	}
	
	public void transpose(int[][] mat) {
		int[][] arr=new int[3][];
		
		
	}
	
}
