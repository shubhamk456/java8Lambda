package package1;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		// code

		System.out.println(solve(exp));

	}

	public static int solve(String exp) {
		Stack<Integer> val = new Stack<>();
		Stack<Character> opt = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char cc = exp.charAt(i);
			if (cc == '(') {
				opt.push(cc);
				System.out.println(opt);
			} else if (cc >= '0' && cc <= '9') {
				val.push(cc - '0');
				System.out.println(val);
			} else if (cc == ')') {

				while (opt.peek() != '(') {
					char op = opt.pop();
					int v2 = val.pop();
					int v1 = val.pop();
					int v = operation(v1, v2, op);
					val.push(v);
				}
				opt.pop();

			} else {
				while (opt.size() > 0 && opt.peek() != '(' && precedence(opt.peek()) >= precedence(cc)) {
					char op = opt.pop();
					int v2 = val.pop();
					int v1 = val.pop();
					int v = operation(v1, v2, op);
					val.push(v);
				}
				opt.push(cc);
				System.out.println(opt);
			}

		}

		while (opt.size() > 0) {
			char op = opt.pop();
			int v2 = val.pop();
			int v1 = val.pop();
			int v = operation(v1, v2, op);
			val.push(v);
		}

		return val.pop();

	}

	public static int operation(int v1, int v2, char opt) {
		if (opt == '+') {
			return v1 + v2;
		} else if (opt == '-') {
			return v1 - v2;

		} else if (opt == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}

	}

	public static int precedence(char opt) {

		if (opt == '*' || opt == '/') {
			return 2;
		} else if (opt == '+' || opt == '-') {
			return 1;
		} else {
			return 0;
		}

	}

}