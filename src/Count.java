package com.jmu.method;

public class Count {
	public static Num count(String op, Num num1, Num num2) {
		// 结果数
		Num result = new Num();
		// 获取分子分母
		int n1 = num1.getNumerator();
		int d1 = num1.getDenominator();
		int n2 = num2.getNumerator();
		int d2 = num2.getDenominator();
		// 判断运算符
		switch (op) {
		case "+":
			if (d1 != d2) {
				n1 = n1 * d2;
				n2 = n2 * d1;
				d1 = d1 * d2;
				result.setNumerator(n1 + n2);
				result.setDenominator(d1);
				result = result.reduction(result);
			} else {
				result.setNumerator(n1 + n2);
				result.setDenominator(d1);
				result = result.reduction(result);
			}
			break;
		case "-":
			if (d1 != d2) {
				n1 = n1 * d2;
				n2 = n2 * d1;
				d1 = d1 * d2;
				d2 = d1;
				result.setNumerator(n1 - n2);
				result.setDenominator(d1);
				result = result.reduction(result);
			} else {
				result.setNumerator(n1 - n2);
				result.setDenominator(d1);
				result = result.reduction(result);
			}
			break;
		case "*":
			result.setNumerator(n1 * n2);
			result.setDenominator(d1 * d2);
			result = result.reduction(result);
			break;
		case "÷":
			if (n2 == 0) {
				result = new Num(0, 0);
				break;
			}
			result.setNumerator(n1 * d2);
			result.setDenominator(d1 * n2);
			result = result.reduction(result);
			break;
		default:
			break;
		}
		return result;
	}

	// 比较两个数的大小
	public static int Max(Num num1, Num num2) {
		// 获取分子分母
		int n1 = num1.getNumerator();
		int d1 = num1.getDenominator();
		int n2 = num2.getNumerator();
		int d2 = num2.getDenominator();
		n1 = n1 * d2;
		n2 = n2 * d1;
		if (n1 > n2) {
			return 1;
		} else if (n1 < n2) {
			return 2;
		} else {
			return 3;
		}
	}
}
