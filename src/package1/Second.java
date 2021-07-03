package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		System.out.println(fibT(110000));
	}

	public static int fibT(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

	}

	public static int fib(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (qb[n] != 0) {
			return qb[n];
		}

		int v1 = fib(n - 1, qb);
		int v2 = fib(n - 2, qb);
		int ans = v1 + v2;

		qb[n] = ans;

		return ans;
	}

	private static ArrayList<String> test1(int n) {
		if (n == 0) {
			ArrayList<String> ba = new ArrayList<>();
			ba.add("");
			return ba;
		}
		if (n < 0) {
			return new ArrayList<>();
		}
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			ArrayList<String> rv = test1(n - i);
			for (String s : rv) {
				ans.add(i + s);
			}

		}
		return ans;
	}

	private static int test(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		int ans = 0;
		for (int i = 1; i < 4; i++) {
			ans += test(n - i);
		}
		return ans;
	}

}
