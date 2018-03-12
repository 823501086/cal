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
				System.out.println("题目，答案与答题文件已生成！");
				System.out.println("请将答案填入答题文件对应位置！");
				break;
			case 2:
				checkAnswer();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("请输入有效操作数！");
				break;
			}
		}

	}

	public static void printView() {
		System.out.println("请选择操作：");
		System.out.println("1:生成题目");
		System.out.println("2:对照答案");
		System.out.println("3:退出");
	}

	public static void creatTimu() throws NumberFormatException, IOException {
		Ac ac = new Ac();
		RPN rpn = new RPN();
		Request req = new Request();
		req.checkFile();
		// 数字范围
		int range = 10;
		// 题目数
		int timu_no = 10;
		InputStreamReader is_reader = new InputStreamReader(System.in);
		System.out.print("请输入数字范围：");
		range = Integer.parseInt(new BufferedReader(is_reader).readLine());
		System.out.print("请输入题目数：");
		timu_no = Integer.parseInt(new BufferedReader(is_reader).readLine());
		// 存放已生成的表达式
		List<Object> timu = new ArrayList<Object>();
		// 存放答案
		List<Object> answer = new ArrayList<Object>();
		for (int i = 1; i <= timu_no; i++) {
			// 生成表达式
			ArrayList<Object> list = ac.createAc(3, range);
			// 生成逆波兰式
			ArrayList<Object> right = rpn.toRPN(list);

			Tree tree = new Tree();
			Ac.toString(list);
			right = rpn.toRPN(list);
			tree = tree.createTree(right);

			// 判断有效性
			if (req.checkRPN(tree.toString(tree))
					&& req.checkAnswer(tree.getValue())) {
				timu.add(list);
				answer.add(tree.getValue());
				// 输出文档
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
