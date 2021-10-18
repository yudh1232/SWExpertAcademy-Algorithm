package _0820;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(in.readLine());
			String infix = in.readLine();
			
			Stack<Character> s = new Stack<Character>();
			
			StringBuilder postfix = new StringBuilder();
			postfix.append(infix.charAt(0));
			for (int i = 1; i < n; i++) {
				if (i % 2 == 1) {
					char c = infix.charAt(i);
					if (c == '+') {
						while (!s.isEmpty()) {
							postfix.append(s.pop());
						}
						s.push(c);
					}
					else {
						while (!s.isEmpty() && s.peek() == '*') {
							postfix.append(s.pop());
						}
						s.push(c);
					}
				}
				else {
					postfix.append(infix.charAt(i));
				}
			}
			
			while (!s.isEmpty()) {
				postfix.append(s.pop());
			}
			
			Stack<Integer> s2 = new Stack<Integer>();
			
			for (int i = 0; i < n; i++) {
				char c = postfix.charAt(i);
				if (c == '+') {
					int a = s2.pop();
					int b = s2.pop();
					s2.push(a + b);
				}
				else if (c == '*') {
					int a = s2.pop();
					int b = s2.pop();
					s2.push(a * b);
				}
				else {
					s2.push(c - '0');
				}
			}
			
			int result = s2.pop();
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
