package com.jmu.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jmu.tree.Tree;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int choose = 0;
		InputStreamReader is_reader = new InputStreamReader(System.in);
		while (choose != 3) {
			printView();
			choose = Integer.parseInt(new BufferedReader(is_reader).readLine());
			switch (choose) {
			case 1:
				creatTimu();
				System.out.println("��Ŀ����������ļ������ɣ�");
				System.out.println("�뽫����������ļ���Ӧλ�ã�");
				break;
			case 2:
				checkAnswer();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("��������Ч��������");
				break;
			}
		}

	}

	public static void printView() {
		System.out.println("��ѡ�������");
		System.out.println("1:������Ŀ");
		System.out.println("2:���մ�");
		System.out.println("3:�˳�");
	}

	public static void creatTimu() throws NumberFormatException, IOException {
		Ac ac = new Ac();
		RPN rpn = new RPN();
		Request req = new Request();
		req.checkFile();
		// ���ַ�Χ
		int range = 10;
		// ��Ŀ��
		int timu_no = 10;
		InputStreamReader is_reader = new InputStreamReader(System.in);
		System.out.print("���������ַ�Χ��");
		range = Integer.parseInt(new BufferedReader(is_reader).readLine());
		System.out.print("��������Ŀ����");
		timu_no = Integer.parseInt(new BufferedReader(is_reader).readLine());
		// ��������ɵı��ʽ
		List<Object> timu = new ArrayList<Object>();
		// ��Ŵ�
		List<Object> answer = new ArrayList<Object>();
		for (int i = 1; i <= timu_no; i++) {
			// ���ɱ��ʽ
			ArrayList<Object> list = ac.createAc(3, range);
			// �����沨��ʽ
			ArrayList<Object> right = rpn.toRPN(list);

			Tree tree = new Tree();
			Ac.toString(list);
			right = rpn.toRPN(list);
			tree = tree.createTree(right);

			// �ж���Ч��
			if (req.checkRPN(tree.toString(tree))
					&& req.checkAnswer(tree.getValue())) {
				timu.add(list);
				answer.add(tree.getValue());
				// ����ĵ�
				// f4.output(i, list, right, result);
			} else {
				i--;
			}
		}
		TxtOutPut.output(timu, answer);
	}

	public static void checkAnswer() {
		Function5 f5 = new Function5();
		f5.compare();
	}
}
