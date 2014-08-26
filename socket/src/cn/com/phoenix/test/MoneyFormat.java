/**
 * Special Declaration: These technical material reserved as the technical 
 * secrets by Bankit TECHNOLOGY have been protected by the "Copyright Law" 
 * "ordinances on Protection of Computer Software" and other relevant 
 * administrative regulations and international treaties. Without the written 
 * permission of the Company, no person may use (including but not limited to 
 * the illegal copy, distribute, display, image, upload, and download) and 
 * disclose the above technical documents to any third party. Otherwise, any 
 * infringer shall afford the legal liability to the company.
 *
 * 鐗瑰埆澹版槑锛氭湰鎶�湳鏉愭枡鍙椼�涓崕浜烘皯鍏卞拰鍥借憲浣滄潈娉曘�銆併�璁＄畻鏈鸿蒋浠朵繚鎶ゆ潯渚嬨�
 * 绛夋硶寰嬨�娉曡銆佽鏀胯绔犱互鍙婃湁鍏冲浗闄呮潯绾︾殑淇濇姢锛屾禉姹熷畤淇＄彮鍏嬩俊鎭妧鏈湁闄愬叕
 * 鍙镐韩鏈夌煡璇嗕骇鏉冦�淇濈暀涓�垏鏉冨埄骞惰鍏朵负鎶�湳绉樺瘑銆傛湭缁忔湰鍏徃涔﹂潰璁稿彲锛屼换浣曚汉
 * 涓嶅緱鎿呰嚜锛堝寘鎷絾涓嶉檺浜庯細浠ラ潪娉曠殑鏂瑰紡澶嶅埗銆佷紶鎾�灞曠ず銆侀暅鍍忋�涓婅浇銆佷笅杞斤級浣�
 * 鐢紝涓嶅緱鍚戠涓夋柟娉勯湶銆侀�闇层�鎶湶銆傚惁鍒欙紝鏈叕鍙稿皢渚濇硶杩界┒渚垫潈鑰呯殑娉曞緥璐ｄ换銆�
 * 鐗规澹版槑锛�
 *
 * Copyright(C) 2012 Bankit Tech, All rights reserved.
 */
/*
 * cn.com.bankit.phoenix.ui.format.MoneyFormat.java
 * Created by jc @ 2012-2-7 涓婂崍1:54:54
 */

package cn.com.phoenix.test;

/**
 * 金额格式化
 * 
 * @author ktwo
 * 
 */
public class MoneyFormat {

	/**
	 * 合法输入字符合集
	 */
	protected static char[] LEGALITY_INPUT_CHAES = new char[] { '-', '+', '0',
			'1', '2', '3', '4', '5', '6', '7', '8', '9', '.' };

	/**
	 * 数字mark
	 */
	protected static char NUMBER_MARK = 'd';

	/**
	 * 0
	 */
	protected String ZERO = "0";

	/**
	 * 格式
	 */
	protected String format;

	/**
	 * 构造函数
	 */
	public MoneyFormat() {
		// do nothing
		this("money,dd,ddd,ddd,ddd,ddd.dd");
	}

	/**
	 * 构造函数
	 * 
	 * @param format
	 */
	public MoneyFormat(String format) {
		this.format = format;
	}

	/**
	 * 金额格式化
	 * 
	 * @param oldValue
	 * @param newValue
	 * @return
	 */
	public String doFormat(String value) {
		String oldValue = value;
		// 2.1 截取并保存符号位
		char sign = '+';
		if (value == null || value.length() == 0) {
			return value;
		}
		if (value.charAt(0) == '-') {
			value = value.substring(1);
			sign = '-';
		}

		// 2.2去除开头位置的零和点
		while (value.indexOf(ZERO) == 0 && value.indexOf('.') != 1) {
			value = value.substring(1);
		}

		// 2.3 按照格式格式化数据
		char[] valueChars = value.toCharArray();
		char[] formatChars = this.format.toCharArray();
		int i = formatChars.length - 1;
		int j = valueChars.length - 1;
		// 长度过长，返回旧值
		if (j > i) {
			return oldValue;
		}

		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {
			if (formatChars[i] == NUMBER_MARK) {
				if (valueChars[j] == '-') {
					if (sign == '-') {
						sign = '+';
					} else {
						sign = '-';
					}
					j--;
				} else if (valueChars[j] == '+') {
					j--;
				} else if (valueChars[j] >= '0' && valueChars[j] <= '9') {
					sb.insert(0, valueChars[j]);
					i--;
					j--;
				} else {
					j--;
				}
			} else if (formatChars[i] == valueChars[j]) {
				sb.insert(0, valueChars[j]);
				j--;
				i--;
			} else {
				sb.insert(0, formatChars[i]);
				i--;
			}
		}

		// 长度过长，返回旧值
		if (i < 0 && j >= 0) {
			return oldValue;
		}
		// 如果第一个字符为'.'符号
		if (sb.charAt(0) == '.') {
			sb.insert(0, '0');
			// 如果删除字符后 首字母为非. 非-的 其余符号 则删除首字符
		} else if (sb.charAt(0) != '.' && sb.charAt(0) != '-'
				&& !(sb.charAt(0) >= '0' && sb.charAt(0) <= '9')) {
			sb.deleteCharAt(0);
		}

		if (sign == '-') {
			sb.insert(0, '-');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MoneyFormat mf = new MoneyFormat("money,dd,ddd,ddd,ddd,ddd.dd");
		String value = mf.doFormat("2134121.23");

		System.out.println(value);
	}
}
