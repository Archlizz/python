package cn.com.phoenix.test;

import javax.swing.*;


public class HelloSwing {
	public void show(){
		JFrame frame = new JFrame("Hello Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setBounds(100, 100, 100, 100);
		
	}
	
}
