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
	 * ��ʾ����
	 */
	JButton button = new JButton("��ť");
	JButton button1 = new JButton("��ť1");
	JButton button2 = new JButton("��ť2");
	JButton button3 = new JButton("��ť3");
	JButton button4 = new JButton("��ť4");
	JButton button5 = new JButton("��ť5");
	JButton button6 = new JButton("��ť6");
	int i = 0;

	public void showWindow() {

		JPanel panel = new JPanel();
		panel.setSize(100, 100);
		// ����
		FlowLayout layout = new FlowLayout();

		button.setMnemonic('N');
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText("��ť������" + (++i) + "��");
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText("������" + (++i) + "��");
			}
		});
		JLabel jl = new JLabel();
		jl.setText("���Գ���");
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		panel.setLayout(layout);
		// ��Ӱ�ť
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
		this.setTitle("����");
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
