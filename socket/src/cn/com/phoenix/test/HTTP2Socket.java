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

public class HTTP2Socket {

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

		// Æ´½Ó×Ö·û´®
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
		
		String value = ReadProp.getInstance().getProperties("hnnxconfig.properties", "envTipText", "²âÊÔ");
		System.out.println(value);
	}// main

}
