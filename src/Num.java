package com.jmu.method;

import java.util.Random;

public class Num {
	private int numerator; // 鍒嗗瓙
	private int denominator; // 鍒嗘瘝

	public Num() {
	}

	public Num(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		if (denominator == 1) {
			return String.valueOf(numerator);
		} else if (numerator > denominator) {
			int mo = numerator / denominator;
			int yu = numerator % denominator;
			return String.valueOf(mo + "`" + yu + "/" + denominator);
		} else if (numerator == 0) {
			return "0";
		}
		return numerator + "/" + denominator;
	}

	// 生成随机数
	public Num createNum(int range) {
		Num num = new Num();
		Random rand = new Random();
		// 生成分子，分母
		int numerator = rand.nextInt(range + 1);
		int denominator = rand.nextInt(10) + 1;
		// 随机生成整数
		if (rand.nextInt(1) == 1) {
			num.setNumerator(numerator);
			num.setDenominator(1);
		} else {
			num.setNumerator(numerator);
			num.setDenominator(denominator);
		}
		// 约分
		num = reduction(num);
		return num;
	}

	// 约分方法
	public Num reduction(Num num) {
		// 取得分子，分母
		int numerator = num.getNumerator();
		int denominator = num.getDenominator();
		if (numerator == 0) {
			num.setDenominator(1);
			return num;
		}
		// 计算最大公约数
		int divisor = getMaxDivisor(numerator, denominator);
		if (divisor == 1) {
			return num;
		} else {
			num.setNumerator(num.getNumerator() / divisor);
			num.setDenominator(num.getDenominator() / divisor);
			return num;
		}
	}

	// 求最大公约数
	public int getMaxDivisor(int numerator, int denominator) {
		if (denominator == 0) {
			return numerator;
		} else {
			return getMaxDivisor(denominator, numerator % denominator);
		}
	}
}
