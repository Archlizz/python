package cn.com.phoenix.test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class HelloSwing extends JFrame{
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 显示窗体
	 */
	JButton button = new JButton("按钮");
	JButton button1 = new JButton("按钮1");
	JButton button2 = new JButton("按钮2");
	JButton button3 = new JButton("按钮3");
	JButton button4 = new JButton("按钮4");
	JButton button5 = new JButton("按钮5");
	JButton button6 = new JButton("按钮6");
	int i = 0;

	public void showWindow() {

		JPanel panel = new JPanel();
		panel.setSize(100, 100);
		// 布局
		FlowLayout layout = new FlowLayout();

		button.setMnemonic('N');
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText("按钮按下了" + (++i) + "次");
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText("按下了" + (++i) + "次");
			}
		});
		JLabel jl = new JLabel();
		jl.setText("测试程序");
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		panel.setLayout(layout);
		// 添加按钮
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(jl);
		panel.setBackground(Color.ORANGE);
		this.add(panel);
		this.setBounds(300, 250, 500, 200);
		this.setBackground(Color.BLUE);
		this.setTitle("窗口");
		// this.setResizable(false);
		// this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	

	}
	
	public void show(){
		JFrame frame = new JFrame("Hello Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setBounds(100, 100, 100, 100);
		
	}
	
}
