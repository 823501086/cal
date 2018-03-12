package com.jmu.method;

import java.util.Random;

public class Num {
	private int numerator; // 分子
	private int denominator; // 分母

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

	// ���������
	public Num createNum(int range) {
		Num num = new Num();
		Random rand = new Random();
		// ���ɷ��ӣ���ĸ
		int numerator = rand.nextInt(range + 1);
		int denominator = rand.nextInt(10) + 1;
		// �����������
		if (rand.nextInt(1) == 1) {
			num.setNumerator(numerator);
			num.setDenominator(1);
		} else {
			num.setNumerator(numerator);
			num.setDenominator(denominator);
		}
		// Լ��
		num = reduction(num);
		return num;
	}

	// Լ�ַ���
	public Num reduction(Num num) {
		// ȡ�÷��ӣ���ĸ
		int numerator = num.getNumerator();
		int denominator = num.getDenominator();
		if (numerator == 0) {
			num.setDenominator(1);
			return num;
		}
		// �������Լ��
		int divisor = getMaxDivisor(numerator, denominator);
		if (divisor == 1) {
			return num;
		} else {
			num.setNumerator(num.getNumerator() / divisor);
			num.setDenominator(num.getDenominator() / divisor);
			return num;
		}
	}

	// �����Լ��
	public int getMaxDivisor(int numerator, int denominator) {
		if (denominator == 0) {
			return numerator;
		} else {
			return getMaxDivisor(denominator, numerator % denominator);
		}
	}
}
