package com.jmu.method;

import java.util.ArrayList;
import java.util.Random;

public class Ac {
	public ArrayList<Object> createAc(int operator_no, int range) {
		// �������ʽ
		ArrayList<Object> ac = new ArrayList<Object>();
		// �����
		Num num = new Num();
		// ��������
		Operator op = new Operator();

		Random rand = new Random();
		// ���ű����
		int bracket = 0;
		// ���Ŷ���
		int bracket_no = 0;
		for (int i = 1; i <= operator_no + 1; i++) {
			// �ж��Ƿ����"("�������ڣ��ж��Ƿ����")",bracket=0ʱ����
			if (bracket_no != 0 && (bracket = rand.nextInt(3)) != 0
					&& ac.get(ac.size() - 1) != "(") {
				// �ų�����
				if (ac.size() != 0 && ac.get(ac.size() - 1).toString() == "��") {
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
			// ������ɵ�����������
			else if (i != operator_no + 1) {

				// �ж��Ƿ���������
				bracket = rand.nextInt(3);
				// backet=0ʱ,����������
				if (bracket == 0) {
					// �ų�����
					if (ac.size() != 0
							&& ac.get(ac.size() - 1).toString() == "��") {
						do {
							num = num.createNum(10);
						} while (num.toString().equalsIgnoreCase("0"));
					} else {
						num = num.createNum(range);
					}
					ac.add(num);
					ac.add(op.createOperator());
				}
				// bracket=1ʱ���ڱ��ʽǰ����������,bracket_no+1
				else if (bracket == 1) {
					ac.add(0, "(");
					// �ų�����
					if (ac.size() != 0
							&& ac.get(ac.size() - 1).toString() == "��") {
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
				// bracket=2ʱ���ڱ��ʽ��󷽼�����,bracket_no+1
				else {
					ac.add("(");
					ac.add(num.createNum(range));
					ac.add(op.createOperator());
					bracket_no++;
				}
			} else {
				// �ų�����
				if (ac.size() != 0 && ac.get(ac.size() - 1).toString() == "��") {
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
		// �Ƿ����δ��Ե�"(",���ھͲ���
		if (bracket_no != 0) {
			ac.remove(ac.size() - 1);
			for (int i = 0; i < bracket_no; bracket_no--) {
				ac.add(")");
			}
		}
		// ȥ������������
		else {
			ac.remove(ac.size() - 1);
		}
		// ȥ�����ʽ���˵�����
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
