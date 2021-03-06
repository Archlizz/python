package cn.com.phoenix.test;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

/**
 * 屏蔽系统级热键demo
 * 
 * @author 廖志杰
 * 
 */
public class RegisterHotkey implements HotkeyListener {

	public static final int KEY_1 = 88;
	public static final int KEY_2 = 89;
	public static final int KEY_3 = 90;
	public static final int F4 = 115;

	/**
	 * 该方法负责监听注册的系统热键事件
	 * 
	 * @param key
	 *            :触发的热键标识
	 */
	public void onHotKey(int key) {
		switch (key) {
		case KEY_1:
			System.out.println("ctrl+alt+I 按下.........");
			break;
		case KEY_2:
			System.out.println("ctrl+alt+O 按下.........");
			break;
		case F4:
			System.out.println("alt+F4   按下            .........");
			break;
		case KEY_3:
			System.out.println("系统退出..........");
			destroy();
		}

	}

	/**
	 * 解除注册并退出
	 */
	void destroy() {
		JIntellitype.getInstance().unregisterHotKey(KEY_1);
		JIntellitype.getInstance().unregisterHotKey(KEY_2);
		JIntellitype.getInstance().unregisterHotKey(KEY_3);
		JIntellitype.getInstance().unregisterHotKey(F4);
		System.exit(0);
	}

	/**
	 * 初始化热键并注册监听事件
	 */
	void initHotkey() {
		// 参数KEY_1表示改组热键组合的标识，第二个参数表示组合键，如果没有则为0，该热键对应ctrl+alt+I
		JIntellitype.getInstance().registerHotKey(KEY_1,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'I');
		JIntellitype.getInstance().registerHotKey(KEY_2,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'O');
		JIntellitype.getInstance().registerHotKey(KEY_3,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'X');
		JIntellitype.getInstance().registerHotKey(F4, JIntellitype.MOD_ALT, F4);

		JIntellitype.getInstance().addHotKeyListener(this);
	}

	public static void main(String[] args) {
		RegisterHotkey key = new RegisterHotkey();
		key.initHotkey();

		// 下面模拟长时间执行的任务
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (Exception ex) {
				break;
			}
		}
	}
}
