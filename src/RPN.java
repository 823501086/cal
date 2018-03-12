package com.jmu.method;

import java.util.ArrayList;
import com.jmu.stacks.Stacks;

public class RPN {
	// �沨��ʽת��
	public ArrayList<Object> toRPN(ArrayList<Object> list) {
		ArrayList<Object> right = new ArrayList<Object>();// �洢������ʽ
		Stacks aStack = new Stacks();// ջ
		String operator;
		int position = 0;// ��ǰָ��λ��
		while (true) {
			// ��ǰָ��Ϊ����
			if (isOperator(list.get(position).toString())) {
				// ջΪ�գ���ָ��Ϊ����ֱ�ӽ�ջ
				if (aStack.top == -1
						|| ((String) list.get(position)).equals("(")) {
					aStack.push(list.get(position));
				} else {
					// ָ��Ϊ��
					if (((String) list.get(position)).equals(")")) {
						// ��ջ�ڣ�����������ջ
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
							// ջ��Ϊ�գ��ж����ȼ�
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
			// ������ջ
			else {
				right.add(list.get(position));
			}
			position++;
			if (position >= list.size())
				break;
		}
		// ջ��ʣ���������ջ
		while (aStack.top != -1) {
			operator = (String) aStack.pop();
			if (!operator.equals("("))
				right.add(operator);
		}
		return right;
	}

	// �ж��Ƿ�Ϊ�����
	public static boolean isOperator(String operator) {
		if (operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("��")
				|| operator.equals("(") || operator.equals(")"))
			return true;
		else
			return false;
	}

	// ���ò������ŵ����ȼ���
	public static boolean priority(String operatorout, String operatorin) {
		int m = -1, n = -1;
		String addop[][] = { { "+", "-", "*", "��", "(", ")" },
				{ "+", "-", "*", "��", "(", ")" } };
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
