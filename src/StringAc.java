package com.jmu.method;

import java.util.Random;

public class StringAc {
	public String createAc(int operator_no, int range) {
		// ���ʽ
		String ac = "";
		Random rand = new Random();
		// ���ű����
		int bracket = 0;
		// ���Ŷ���
		int bracket_no = 0;
		for (int i = 1; i <= operator_no + 1; i++) {
			// �ж��Ƿ����"("�������ڣ��ж��Ƿ����")",bracket=0ʱ����
			if (bracket_no != 0 && (bracket = rand.nextInt(3)) != 0
					&& ac.charAt(ac.length() - 1) != '(') {
				ac = ac + "N" + ")" + "+";
				bracket_no--;
			}
			// ������ɵ�����������
			else if (i != operator_no + 1) {

				// �ж��Ƿ���������
				bracket = rand.nextInt(3);
				// backet=0ʱ,����������
				if (bracket == 0) {
					ac = ac + "N" + "+";
				}
				// bracket=1ʱ���ڱ��ʽǰ����������,bracket_no+1
				else if (bracket == 1) {
					ac = "(" + ac + "N" + "+";
					bracket_no++;
				}
				// bracket=2ʱ���ڱ��ʽ��󷽼�����,bracket_no+1
				else {
					ac = ac + "(" + "N" + "+";
					bracket_no++;
				}
			} else {
				ac = ac + "N" + "+";
			}
		}
		// �Ƿ����δ��Ե�"(",���ھͲ���
		if (bracket_no != 0) {
			ac = ac.substring(0, ac.length() - 1);
			for (int i = 0; i < bracket_no; bracket_no--) {
				ac = ac + ")";
			}
		}
		// ȥ������������
		else {
			ac = ac.substring(0, ac.length() - 1);
		}
		// ȥ�����ʽ���˵�����
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
