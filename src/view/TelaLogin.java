package view;
/**
 * @Tela de login
 * @author y038675
 * @version 1.0
 * @Tela de login simples, cadastro apenas por gerentes
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoDAO;
import controller.UsuarioDAO;
import model.Produto;
import model.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setUndecorated(true); // Tirar a borda
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 400); // Aparentemente é onde vai abrir a JFrame os 1 e 2 -- Usar 0 0 pois na classe a baixo definimos para centralizar
		setLocationRelativeTo(null); // Centralizar tela
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 50, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 880, 21);
		contentPane.add(menuBar);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JButton btnNewButton = new JButton("Como cadastrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btnNewButton.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setForeground(Color.BLACK);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Para efetuar o cadastro peça para o coordenador responsável pela área", "Cadastro", JOptionPane.PLAIN_MESSAGE);

			}
		});
		mnOpes.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 339, 480);
		contentPane.add(panel);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(394, 140, 200, 30);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula : ");
		lblMatricula.setForeground(Color.WHITE);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatricula.setBounds(394, 115, 72, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(394, 181, 55, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(394, 206, 200, 30);
		contentPane.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDAO uDAO = new UsuarioDAO();
				if(uDAO.confereLogin(txtMatricula.getText(), new String (txtSenha.getPassword()))) { //Conferir se o String vai funcionar
					
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema " +lerJTablePorNome(txtMatricula.getText())); //Manipular melhor a tela
					
					TelaPrincipal telaSist = new TelaPrincipal();
					telaSist.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Dados invalidos", "Erro", JOptionPane.ERROR_MESSAGE);  //Manipular melhor a tela
					
				}
			}
		});
		btnEntrar.setForeground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEntrar.setBounds(394, 312, 102, 34);
		contentPane.add(btnEntrar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFechar.setForeground(Color.DARK_GRAY);
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFechar.setBounds(532, 312, 102, 34);
		contentPane.add(btnFechar);
	}
	
	public String lerJTablePorNome(String matricula) {
		UsuarioDAO uDAO = new UsuarioDAO();

		for (Usuario u : uDAO.buscaNomePorMatricula(matricula)) {
			return u.getNome();

		}
		
		return null;
	}
}
