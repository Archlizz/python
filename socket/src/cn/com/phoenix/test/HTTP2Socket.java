package cn.com.phoenix.test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.swt.widgets.Layout;

public class HTTP2Socket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// String info = BcmpSocket.send("11.0.160.164", 9050);

		// BaiduSocket baidu = new BaiduSocket("111.13.100.91", 80, "java");
		// String info = baidu.searchRequest();
		// HelloSwing swing = new HelloSwing();
		// swing.show();

		// List list = TestMap.RestoreData();
		// System.out.println(list.toString());
		// @SuppressWarnings("deprecation")
		// Date startDate = new Date(2014,4,44);
		// ExcelShell excelShell = new ExcelShell();
		// excelShell.openExcelShell();
		// int x = 3;
		// int y = -x;
		// System.out.println(y);

		// Map map = TestMap.RestoreData();

		// 拼接字符串
		// String data = "|212||321";
		// String remainData = "";
		// int index = 0;
		// int index2 = 0;
		// String[] infos = new String[4];
		// // String year = remainData.substring(beginIndex, endIndex)
		// int len = data.length();
		// remainData = data;
		// int i = 0;
		// while (index2 != -1) {
		// index = index2;
		// index2 = remainData.indexOf("|");
		// infos[i] = remainData.substring(0,
		// index2!=-1?index2:remainData.length());
		// remainData = remainData.substring(index2 + 1, remainData.length());
		// i++;
		// }
		HTTP2Socket swing = new HTTP2Socket();
		swing.showWindow();
	}// main

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
}
