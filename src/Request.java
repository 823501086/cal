package com.jmu.method;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Request {
	// �����ɵ���Ŀ
	ArrayList<Object> check = new ArrayList<Object>();
	int answer = 1;
	int RPN = 1;

	public boolean checkAnswer(Num result) {
		if ((result.getNumerator() * result.getDenominator()) >= 0) {
			return true;
		} else {
			// System.out.println("����Ч��" + (answer++));
			return false;
		}
	}

	public boolean checkRPN(String list) {
		if (check.size() == 0) {
			check.add(list);
			return true;
		} else {
			for (int i = 0; i < check.size(); i++) {
				if (check.get(i).equals(list)) {
					// System.out.println("�ظ���" + (RPN++));
					return false;
				}
			}
		}
		check.add(list);
		return true;
	}

	public void checkFile() {
		File timu = new File("timu.txt");
		File answer = new File("answer.txt");
		File answer_do = new File("do.txt");
		// File timu = new File("H:/D4/rjgc/work1/timu.txt");
		// File answer = new File("H:/D4/rjgc/work1/answer.txt");
		// File answer_do = new File("H:/D4/rjgc/work1/do.txt");
		try {
			if (timu.exists()) {
				timu.delete();
				System.out.println("ɾ��������Ŀ��");
			}
			timu.createNewFile();
			System.out.println("������Ŀ�ļ���");
			if (answer.exists()) {
				answer.delete();
				System.out.println("ɾ�����д𰸣�");
			}
			answer.createNewFile();
			System.out.println("���ɴ��ļ���");
			if (answer_do.exists()) {
				answer_do.delete();
				System.out.println("ɾ�����д��⣡");
			}
			answer_do.createNewFile();
			System.out.println("���ɴ����ļ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
