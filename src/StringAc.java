package com.jmu.method;

import java.util.Random;

public class StringAc {
	public String createAc(int operator_no, int range) {
		// 表达式
		String ac = "";
		Random rand = new Random();
		// 括号标记数
		int bracket = 0;
		// 括号对数
		int bracket_no = 0;
		for (int i = 1; i <= operator_no + 1; i++) {
			// 判断是否存在"("，若存在，判断是否加上")",bracket=0时不加
			if (bracket_no != 0 && (bracket = rand.nextInt(3)) != 0
					&& ac.charAt(ac.length() - 1) != '(') {
				ac = ac + "N" + ")" + "+";
				bracket_no--;
			}
			// 最后生成的数不加括号
			else if (i != operator_no + 1) {

				// 判断是否生成括号
				bracket = rand.nextInt(3);
				// backet=0时,不生成括号
				if (bracket == 0) {
					ac = ac + "N" + "+";
				}
				// bracket=1时，在表达式前方生成括号,bracket_no+1
				else if (bracket == 1) {
					ac = "(" + ac + "N" + "+";
					bracket_no++;
				}
				// bracket=2时，在表达式后后方加括号,bracket_no+1
				else {
					ac = ac + "(" + "N" + "+";
					bracket_no++;
				}
			} else {
				ac = ac + "N" + "+";
			}
		}
		// 是否存在未配对的"(",存在就补上
		if (bracket_no != 0) {
			ac = ac.substring(0, ac.length() - 1);
			for (int i = 0; i < bracket_no; bracket_no--) {
				ac = ac + ")";
			}
		}
		// 去除多余的运算符
		else {
			ac = ac.substring(0, ac.length() - 1);
		}
		// 去除表达式两端的括号
		while (ac.charAt(0) == '(') {
			bracket = 0;
			int bracket_leng = 0;
			char o = ' ';
			for (int j = 0; j < ac.length(); j++) {
				o = ac.charAt(j);
				if (o == '(') {
					bracket++;
					bracket_leng--;
				}
				if (o == ')') {
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
				ac = ac.substring(1, ac.length() - 1);
			}
		}
		return ac;
	}
}
