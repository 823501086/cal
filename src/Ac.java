package com.jmu.method;

import java.util.ArrayList;
import java.util.Random;

public class Ac {
	public ArrayList<Object> createAc(int operator_no, int range) {
		// 算数表达式
		ArrayList<Object> ac = new ArrayList<Object>();
		// 随机数
		Num num = new Num();
		// 随机运算符
		Operator op = new Operator();

		Random rand = new Random();
		// 括号标记数
		int bracket = 0;
		// 括号对数
		int bracket_no = 0;
		for (int i = 1; i <= operator_no + 1; i++) {
			// 判断是否存在"("，若存在，判断是否加上")",bracket=0时不加
			if (bracket_no != 0 && (bracket = rand.nextInt(3)) != 0
					&& ac.get(ac.size() - 1) != "(") {
				// 排除除零
				if (ac.size() != 0 && ac.get(ac.size() - 1).toString() == "÷") {
					do {
						num = num.createNum(10);
					} while (num.toString().equalsIgnoreCase("0"));
				} else {
					num = num.createNum(range);
				}
				ac.add(num);
				ac.add(")");
				ac.add(op.createOperator());
				bracket_no--;
			}
			// 最后生成的数不加括号
			else if (i != operator_no + 1) {

				// 判断是否生成括号
				bracket = rand.nextInt(3);
				// backet=0时,不生成括号
				if (bracket == 0) {
					// 排除除零
					if (ac.size() != 0
							&& ac.get(ac.size() - 1).toString() == "÷") {
						do {
							num = num.createNum(10);
						} while (num.toString().equalsIgnoreCase("0"));
					} else {
						num = num.createNum(range);
					}
					ac.add(num);
					ac.add(op.createOperator());
				}
				// bracket=1时，在表达式前方生成括号,bracket_no+1
				else if (bracket == 1) {
					ac.add(0, "(");
					// 排除除零
					if (ac.size() != 0
							&& ac.get(ac.size() - 1).toString() == "÷") {
						do {
							num = num.createNum(10);
						} while (num.toString().equalsIgnoreCase("0"));
					} else {
						num = num.createNum(range);
					}
					ac.add(num);
					ac.add(op.createOperator());
					bracket_no++;
				}
				// bracket=2时，在表达式后后方加括号,bracket_no+1
				else {
					ac.add("(");
					ac.add(num.createNum(range));
					ac.add(op.createOperator());
					bracket_no++;
				}
			} else {
				// 排除除零
				if (ac.size() != 0 && ac.get(ac.size() - 1).toString() == "÷") {
					do {
						num = num.createNum(10);
					} while (num.toString().equalsIgnoreCase("0"));
				} else {
					num = num.createNum(range);
				}
				ac.add(num);
				ac.add(op.createOperator());
			}
		}
		// 是否存在未配对的"(",存在就补上
		if (bracket_no != 0) {
			ac.remove(ac.size() - 1);
			for (int i = 0; i < bracket_no; bracket_no--) {
				ac.add(")");
			}
		}
		// 去除多余的运算符
		else {
			ac.remove(ac.size() - 1);
		}
		// 去除表达式两端的括号
		while (ac.get(0) == "(") {
			bracket = 0;
			int bracket_leng = 0;
			String o = "";
			for (int j = 0; j < ac.size(); j++) {
				o = ac.get(j).toString();
				if (o == "(") {
					bracket++;
					bracket_leng--;
				}
				if (o == ")") {
					bracket--;
					bracket_leng--;
				}
				if (bracket == 0 && bracket_leng != (2 * operator_no)) {
					return ac;
				}
				if (bracket >= 1) {
					bracket_leng++;
				}
			}
			if (bracket_leng == (2 * operator_no)) {
				ac.remove(0);
				ac.remove(ac.size() - 1);
			}
		}
		return ac;
	}

	public static String toString(ArrayList<Object> list) {
		String s1 = "";
		for (int i = 0; i < list.size(); i++) {
			s1 += list.get(i).toString();
		}
		return s1;
	}
}
