package com.jmu.method;

import java.util.ArrayList;
import com.jmu.stacks.Stacks;

public class RPN {
	// 逆波兰式转换
	public ArrayList<Object> toRPN(ArrayList<Object> list) {
		ArrayList<Object> right = new ArrayList<Object>();// 存储右序表达式
		Stacks aStack = new Stacks();// 栈
		String operator;
		int position = 0;// 当前指针位置
		while (true) {
			// 当前指针为符号
			if (isOperator(list.get(position).toString())) {
				// 栈为空，或指针为（，直接进栈
				if (aStack.top == -1
						|| ((String) list.get(position)).equals("(")) {
					aStack.push(list.get(position));
				} else {
					// 指针为）
					if (((String) list.get(position)).equals(")")) {
						// 将栈内（后的运算符出栈
						while (true) {
							if (aStack.top != -1
									&& !((String) aStack.top()).equals("(")) {
								operator = (String) aStack.pop();
								right.add(operator);
							} else {
								if (aStack.top != -1)
									aStack.pop();
								break;
							}
						}
					} else {
						while (true) {
							// 栈不为空，判断优先级
							if (aStack.top != -1
									&& priority((String) list.get(position),
											(String) aStack.top())) {
								operator = (String) aStack.pop();
								if (!operator.equals("("))
									right.add(operator);
							} else {
								break;
							}

						}
						aStack.push(list.get(position));
					}
				}
			}
			// 数字入栈
			else {
				right.add(list.get(position));
			}
			position++;
			if (position >= list.size())
				break;
		}
		// 栈内剩余运算符出栈
		while (aStack.top != -1) {
			operator = (String) aStack.pop();
			if (!operator.equals("("))
				right.add(operator);
		}
		return right;
	}

	// 判断是否为运算符
	public static boolean isOperator(String operator) {
		if (operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("÷")
				|| operator.equals("(") || operator.equals(")"))
			return true;
		else
			return false;
	}

	// 设置操作符号的优先级别
	public static boolean priority(String operatorout, String operatorin) {
		int m = -1, n = -1;
		String addop[][] = { { "+", "-", "*", "÷", "(", ")" },
				{ "+", "-", "*", "÷", "(", ")" } };
		int first[][] = { { 1, 1, 2, 2, 2, 0 }, { 1, 1, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 2, 0 }, { 1, 1, 1, 1, 2, 0 },
				{ 2, 2, 2, 2, 2, 0 }, { 2, 2, 2, 2, 2, 2 } };
		for (int i = 0; i < 6; i++) {
			if (operatorin.equalsIgnoreCase(addop[0][i]))
				m = i;
		}
		for (int i = 0; i < 6; i++) {
			if (operatorout.equalsIgnoreCase(addop[1][i]))
				n = i;
		}
		if (m == -1 && n == -1)
			return false;
		else if (m == -1 && n != -1)
			return false;
		else if (m != -1 && n == -1)
			return true;
		else if (first[m][n] == 1) {
			return true;
		} else
			return false;
	}
}
