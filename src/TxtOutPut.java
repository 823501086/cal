package com.jmu.method;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TxtOutPut {
	// 输出
	@SuppressWarnings("unchecked")
	public static void output(List<Object> list1, List<Object> list2) {
		Ac ac = new Ac();
		int i = 0;
		try {
			// 找到TXT位置
			// String file = "H:/D4/rjgc/work1/timu.txt";
			String file1 = "timu.txt";
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file1, true)));
				Iterator<Object> itr = list1.iterator();
				while (itr.hasNext()) {
					if (i >= list1.size()) {
						break;
					}
					String timu = (i + 1) + ","
							+ ac.toString((ArrayList<Object>) list1.get(i));
					out.write(timu);
					out.newLine();
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		i = 0;
		try {
			// 文件位置
			// String file1 = "H:/D4/rjgc/work1/answer.txt";
			// String file2 = "H:/D4/rjgc/work1/do.txt";
			String file3 = "answer.txt";
			String file4 = "do.txt";
			// 创建输出流
			BufferedWriter out = null;
			BufferedWriter out_do = null;
			try {
				// 定位输出位置
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file3, true)));
				out_do = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file4, true)));
				Iterator<Object> itr = list2.iterator();
				while (itr.hasNext()) {
					if (i >= list2.size()) {
						break;
					}
					String answer = (i + 1) + "," + list2.get(i).toString();
					out.write(answer);
					out.newLine();
					out_do.write((i + 1) + ",");
					out_do.newLine();
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
					out_do.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
