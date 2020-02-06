package com.code.practice.java8.problem;

public class NthLargest {

	int array[] = { 10, 19, 2, 3, 1, 98, 75, 65, 8500, 850000 };

	public static void main(String args[]) throws MyException {
		new NthLargest(5);
	}

	public NthLargest(int n) throws MyException {

		int skip[] = new int[n];
		int i, j, k, l, skipIndex = 0, maxJ = 0;
		int nthMaxValue = 0;
		boolean skipLoop = false;

		if (n > array.length)
			throw new MyException("Out of scope to grab this number");

		for (i = 0; i < array.length; i++) {
			int val = array[i];
			maxJ = i;
			for (j = 0; j < array.length; j++) {

				for (k = 0; k < skip.length; k++)
					if (skip[k] == j)
						skipLoop = true;

				if (skipLoop) {
					skipLoop = false;
					continue;
				}
				if (val < array[j]) {
					val = array[j];
					maxJ = j;
				}
			}
			if (skipIndex == n) {
				nthMaxValue = array[skip[n - 1]];
				break;
			}

			skip[skipIndex++] = maxJ;
		}
		System.out.println(n + " largest value is : " + nthMaxValue);
	}
}

class MyException extends Exception {
	String msg = "";

	MyException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}