package MineProject;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	public static void main(String[] args) {
		
		try {
			/****
			 * We are calling the 'setLookAndFeel' method of UIManager class and passing the 
			 * getSystemLookAndFeelClassName(), so that user interface as chess in this example
			 *  would be shown accordingly MAC or windows or any OS. 
			 */
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		/* Starting different thread to run 'MainFrame' application.
		 * 'MainFrame' is going to have button and chess board like table. */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}
}
