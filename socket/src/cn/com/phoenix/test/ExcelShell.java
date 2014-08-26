package cn.com.phoenix.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class ExcelShell {

	public void openExcelShell() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(600, 400);
		shell.setText("Excel Window");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		shell.setMenuBar(new Menu(shell, SWT.BAR));

		this.createExcelPart(shell);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.close();
	}

	/**
	 * 将Excel 嵌入到Shell中
	 * 
	 * @param shell
	 */
	private void createExcelPart(Shell shell) {
		OleFrame oleFrame = new OleFrame(shell, SWT.NONE);
		OleClientSite clientSite = new OleClientSite(oleFrame, SWT.NONE,
				"Word.Document");
		clientSite.setVisible(true);
		clientSite.doVerb(OLE.OLEIVERB_SHOW);
	}

}
