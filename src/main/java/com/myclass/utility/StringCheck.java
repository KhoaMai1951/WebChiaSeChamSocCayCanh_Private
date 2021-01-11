package com.myclass.utility;

public class StringCheck {
	
	/**
	 * Trả true nếu chuỗi input có chứa các kí tự đặc biệt
	 * */
	public static boolean checkSpecialChar(String input) {
		char[] charArray = input.toCharArray();
		for(char ch : charArray) {
			if(ch == '<' || ch == '>' || ch == '.' || ch == ',' || ch == '/' || ch == '\\' 
					|| ch == '|' || ch == '\'' || ch == '\"' || ch == '{' || ch == '}' 
					|| ch == '[' || ch ==']' || ch == '!' || ch == '@' || ch == '#'
					|| ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'
					|| ch == '(' || ch == ')' || ch == '_' || ch == '-' || ch == '=' 
					|| ch == '+' || ch == '~' || ch == '`' || ch == '?') {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Trả true nếu chuỗi input có chứa các kí tự đặc biệt(trừ @,.)
	 * */
	public static boolean checkSpecialCharInEmail(String input) {
		char[] charArray = input.toCharArray();
		for(char ch : charArray) {
			if(ch == '<' || ch == '>' || ch == ',' || ch == '/' || ch == '\\' 
					|| ch == '|' || ch == '\'' || ch == '\"' || ch == '{' || ch == '}' 
					|| ch == '[' || ch ==']' || ch == '!'  || ch == '#'
					|| ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'
					|| ch == '(' || ch == ')' || ch == '_' || ch == '-' || ch == '=' 
					|| ch == '+' || ch == '~' || ch == '`' || ch == '?') {
				return true;
			}
		}
		
		return false;
	}

}
