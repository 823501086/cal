package com.jmu.method;

import java.util.Random;

public class Operator {
	// 生成随机运算符
	public String createOperator() {
		String operator = null;
		Random rand = new Random();
		int n = rand.nextInt(4);
		switch (n) {
		case 0:
			operator = "+";
			break;
		case 1:
			operator = "-";
			break;
		case 2:
			operator = "*";
			break;
		case 3:
			operator = "÷";
			break;
		default:
			operator = "+";
			break;
		}
		return operator;
	}
}
