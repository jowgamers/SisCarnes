package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import connection.ConnectionManager;
import controller.DAOUtil;

public class TelaPrincipal extends JFrame {

	DAOUtil dUtil = new DAOUtil();

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private String qntFrn;
	private String qntCli;
	private String qntProd;
	private String qntVnd;
	private JLabel lblVend;
	private JLabel lblCli;
	private JLabel lblProd;
	private JLabel lblFrn;

	public void trocarPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}

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
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Fazer a conexão com o banco de dados
		try {
			ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public TelaPrincipal() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 980, 580); // Aparentemente é onde vai abrir a JFrame os 2 1borda, usar 0 e 0 para
									// centralizar
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 50, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * qntFrn = dUtil.qntdRegis("fornecedores"); qntCli =
		 * dUtil.qntdRegis("clientes"); qntProd = dUtil.qntdRegis("produtos"); qntVnd =
		 * dUtil.qntdRegis("vendedores");
		 */

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new java.awt.Color(77, 80, 97)); // AZUL ESCURO
		panel.setBounds(0, 0, 153, 580);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnVendedor = new JButton("");
		btnVendedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/vendedores.png")));
		btnVendedor.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/vendedoreshvr.png")));
		btnVendedor.setFocusable(false);
		btnVendedor.setForeground(Color.WHITE);
		btnVendedor.setContentAreaFilled(false);
		btnVendedor.setBounds(0, 193, 155, 35);
		panel.add(btnVendedor);

		JButton btnForne = new JButton("");
		btnForne.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/Fornecedore.png")));
		btnForne.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/Fornecedoreshvr.png")));
		btnForne.setFocusable(false);
		btnForne.setForeground(Color.WHITE);
		btnForne.setContentAreaFilled(false);
		btnForne.setBounds(0, 253, 155, 35);
		panel.add(btnForne);

		JButton btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/Clientes.png")));
		btnCliente.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/Clienteshvr.png")));
		btnCliente.setFocusable(false);
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBounds(0, 373, 155, 35);
		panel.add(btnCliente);

		JButton btnProd = new JButton("");
		btnProd.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/carnes.png")));
		btnProd.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/carneshvr.png")));
		btnProd.setFocusable(false);
		btnProd.setForeground(Color.WHITE);
		btnProd.setBounds(0, 313, 155, 35);
		panel.add(btnProd);
		btnProd.setContentAreaFilled(false);

		JButton btnInicial = new JButton("");
		btnInicial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/inicio.png")));
		btnInicial.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/iniciohvr.png")));
		btnInicial.setFocusable(false);
		btnInicial.setContentAreaFilled(false);
		btnInicial.setForeground(Color.WHITE);
		btnInicial.setBounds(0, 133, 155, 35);
		panel.add(btnInicial);

		JLabel lblNome = new JLabel("Joao");
		lblNome.setBounds(59, 66, 37, 14);
		panel.add(lblNome);
		lblNome.setForeground(SystemColor.desktop);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnImprimir = new JButton("");
		btnImprimir.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/consultahvr.png")));
		btnImprimir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/consulta.png")));
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFocusable(false);
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setBounds(0, 433, 155, 35);
		panel.add(btnImprimir);

		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(155, 25, 825, 555);
		contentPane.add(panelInicial);
		panelInicial.setBackground(Color.DARK_GRAY);
		panelInicial.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 825, 555);
		panelInicial.add(layeredPane);
		layeredPane.setLayout(null);

		JPanel panelPrinc = new JPanel();
		panelPrinc.setBounds(0, 0, 825, 555);
		layeredPane.add(panelPrinc);
		panelPrinc.setBackground(new Color(48, 50, 61));
		panelPrinc.setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setBounds(284, 105, 46, 14);
		panelPrinc.add(lblClientes);

		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setForeground(Color.WHITE);
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVendedores.setBounds(63, 105, 68, 14);
		panelPrinc.add(lblVendedores);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setForeground(Color.WHITE);
		lblFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFornecedores.setBounds(688, 105, 78, 14);
		panelPrinc.add(lblFornecedores);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProdutos.setBounds(492, 105, 50, 14);
		panelPrinc.add(lblProdutos);

		DAOUtil dUtil = new DAOUtil();

		JLabel lblCli = new JLabel("1");
		// lblCli = new JLabel(qntCli);
		// JLabel lblCli = new JLabel(dUtil.qntdRegis("clientes"));
		lblCli.setForeground(SystemColor.desktop);
		lblCli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCli.setBounds(300, 71, 15, 34);
		panelPrinc.add(lblCli);

		JLabel lblVend = new JLabel("1");
		// lblVend = new JLabel(qntVnd);
		// JLabel lblVend = new JLabel(dUtil.qntdRegis("vendedores"));
		lblVend.setForeground(SystemColor.desktop);
		lblVend.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblVend.setBounds(90, 71, 15, 34);
		panelPrinc.add(lblVend);

		JLabel lblFrn = new JLabel("1");
		// lblFrn = new JLabel(qntFrn);
		// JLabel lblFrn = new JLabel(dUtil.qntdRegis("fornecedores"));
		lblFrn.setForeground(SystemColor.desktop);
		lblFrn.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFrn.setBounds(720, 71, 15, 34);
		panelPrinc.add(lblFrn);

		JLabel lblProd = new JLabel("1");
		// lblProd = new JLabel(qntProd);
		// JLabel lblProd =new JLabel(dUtil.qntdRegis("produtos"));
		lblProd.setForeground(SystemColor.desktop);
		lblProd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblProd.setBounds(510, 71, 15, 34);
		panelPrinc.add(lblProd);

		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(274, 156, 277, 242);
		panelPrinc.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_fechar = new JLabel("X");
		lbl_fechar.setBounds(944, 2, 34, 27);
		contentPane.add(lbl_fechar);
		lbl_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int reply = JOptionPane.showConfirmDialog(null, "Voce deseja realmente sair ? ", "Saida", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Até Logo");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Bem vindo novamente");
				}
			}
		});
		lbl_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fechar.setForeground(new Color(224, 255, 255));
		lbl_fechar.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lbl_mini = new JLabel("-");
		lbl_mini.setBounds(909, -1, 34, 27);
		contentPane.add(lbl_mini);
		lbl_mini.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_mini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				setState(ICONIFIED);
			}
		});
		lbl_mini.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mini.setForeground(new Color(224, 255, 255));
		lbl_mini.setFont(new Font("Tahoma", Font.PLAIN, 30));

		/**
		 * Botões para a troca de telas
		 */
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProduto telaProd = new TelaProduto();
				trocarPanel(telaProd);
			}
		});

		btnInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * qntFrn = dUtil.qntdRegis("fornecedores"); lblFrn.setText(qntFrn);
				 * 
				 * qntCli = dUtil.qntdRegis("clientes"); lblCli.setText(qntCli);
				 * 
				 * qntProd = dUtil.qntdRegis("produtos"); lblProd.setText(qntProd);
				 * 
				 * qntVnd = dUtil.qntdRegis("vendedores"); lblVend.setText(qntVnd);
				 */
				trocarPanel(panelPrinc);
			}
		});

		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendedor telaVende = new TelaVendedor();
				trocarPanel(telaVende);
			}
		});

		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultas telaconsultas = new TelaConsultas();
				trocarPanel(telaconsultas);
			}
		});

		btnForne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFornecedor telaForne = new TelaFornecedor();
				trocarPanel(telaForne);
			}
		});

		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente telaCliente = new TelaCliente();
				trocarPanel(telaCliente);
			}
		});

	}
}
