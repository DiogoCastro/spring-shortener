package com.diogo.springshortener.commom;

import java.util.Random;

public class Converter {
	
	public String getGenerateName(int size) {
		char[] letters = "bZwCF8gSak4Ru1KVoz2yJXQrPTmi7Mc3BH0Lv5YtsWlOIDdfN6qGejAp9xUEnh".toCharArray();
		StringBuffer str = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			Random rand = new Random();
			str.append(letters[rand.nextInt(letters.length)]);
		}
		
		return str.toString();
	}
}
