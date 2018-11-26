package sisCarnes;
/**
 * 
 * @descricao Classe Main, inicializadora do sistema, executa primeiro a splash screen, tela login, tela principal respectivamente
 * @author Joao Vitor
 * @package sisCarnes
 * @version 1.0
 * 
 */
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.Splash;
import view.TelaLogin;

public class Main {
	public static void main(String args[]) throws Exception {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// Excessão para se não achar a nimbus posso colocar outra laF
		}
		
		Splash s = new Splash();
		s.setVisible(true);
		Thread t = Thread.currentThread();
		t.sleep(10000);
		s.dispose();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				TelaLogin telaLog = new TelaLogin();
				telaLog.setVisible(true);
			}
		});
	}

}