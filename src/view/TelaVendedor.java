package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoDAO;
import controller.UsuarioDAO;
import controller.VendedorDAO;
import model.Vendedor;

public class TelaVendedor extends JPanel {
	private JTextField txtNomeVend;
	private JTextField txtTelVend;
	private JTextField txtEmlVnd;
	private JTextField txtMetaMensal;
	private JTextField txtCpfVnd;
	private JTable jTVend;
	private JTextField txtCNome;
	private JTextField txtCCpf;
	private JTextField txtCTel;
	private JTextField txtCEmail;
	private JTextField txtCMetaMes;
	private JTextField txtBuscaNome;

	/**
	 * Create the panel.
	 */
	public TelaVendedor() {
		setBackground(new Color(48, 50, 61));
		setBounds(0, 0, 825, 555);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(500, 300));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 60, 825, 495);
		add(tabbedPane);
		
		JPanel pnlConsultar = new JPanel();
		tabbedPane.addTab("Consultar", null, pnlConsultar, null);
		pnlConsultar.setLayout(null);
		

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTVend.getSelectedRow() != -1) {

					Vendedor v = new Vendedor();
					VendedorDAO vDAO = new VendedorDAO();
					v.setNome(txtCNome.getText());
					v.setCpf(txtCCpf.getText());
					v.setEmail(txtCEmail.getText());
					v.setMetaMensal(Double.parseDouble(txtCMetaMes.getText()));
					v.setTelefones(txtCTel.getText());
					v.setCodigo((int) jTVend.getValueAt(jTVend.getSelectedRow(), 0));
					
					vDAO.update(v);

					txtNomeVend.setText("");
					txtCpfVnd.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					lerJTable();

				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnAtualizar.setBounds(675, 25, 75, 23);
		pnlConsultar.add(btnAtualizar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 800, 342);
		pnlConsultar.add(scrollPane);

		
		jTVend = new JTable();
		jTVend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTVend.getSelectedRow() != -1) {
					
					txtCNome.setText(jTVend.getValueAt(jTVend.getSelectedRow(), 1).toString());
					txtCTel.setText(jTVend.getValueAt(jTVend.getSelectedRow(), 2).toString());
					txtCCpf.setText(jTVend.getValueAt(jTVend.getSelectedRow(), 3).toString());
					txtCEmail.setText(jTVend.getValueAt(jTVend.getSelectedRow(), 4).toString());
					txtCMetaMes.setText(jTVend.getValueAt(jTVend.getSelectedRow(), 6).toString());

				}
			}
		});
		jTVend.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Vendedor", "Nome", "Telefone", "Cpf", "Email", "Data Cadastro", "Meta Mensal"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTVend);
		
		txtCNome = new JTextField();
		txtCNome.setBounds(9, 25, 150, 29);
		pnlConsultar.add(txtCNome);
		txtCNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 11, 46, 14);
		pnlConsultar.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF : ");
		lblCpf.setBounds(170, 11, 46, 14);
		pnlConsultar.add(lblCpf);
		
		txtCCpf = new JTextField();
		txtCCpf.setColumns(10);
		txtCCpf.setBounds(169, 25, 150, 29);
		pnlConsultar.add(txtCCpf);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(330, 11, 59, 14);
		pnlConsultar.add(lblTelefone);
		
		txtCTel = new JTextField();
		txtCTel.setColumns(10);
		txtCTel.setBounds(329, 25, 94, 29);
		pnlConsultar.add(txtCTel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(434, 11, 59, 14);
		pnlConsultar.add(lblEmail);
		
		txtCEmail = new JTextField();
		txtCEmail.setColumns(10);
		txtCEmail.setBounds(433, 25, 128, 29);
		pnlConsultar.add(txtCEmail);
		
		JLabel lblMetaMs = new JLabel("Meta M\u00EAs : ");
		lblMetaMs.setBounds(572, 11, 75, 14);
		pnlConsultar.add(lblMetaMs);
		
		txtCMetaMes = new JTextField();
		txtCMetaMes.setColumns(10);
		txtCMetaMes.setBounds(571, 25, 94, 29);
		pnlConsultar.add(txtCMetaMes);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTVend.getSelectedRow() != -1) {

					Vendedor v = new Vendedor();
					VendedorDAO vDAO = new VendedorDAO();

					v.setCodigo((int) jTVend.getValueAt(jTVend.getSelectedRow(), 0));

					vDAO.delete(v);

					txtNomeVend.setText("");
					txtCpfVnd.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					lerJTable();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir.setBounds(675, 54, 75, 23);
		pnlConsultar.add(btnExcluir);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setBounds(10, 65, 149, 31);
		pnlConsultar.add(txtBuscaNome);
		
		JButton btnBuscarPorCpf = new JButton("Buscar por CPF");
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lerJTablePorCpf(txtBuscaNome.getText());
			}
		});
		btnBuscarPorCpf.setBounds(170, 65, 150, 31);
		pnlConsultar.add(btnBuscarPorCpf);
		
		JButton button = new JButton("Imprime Ordem Alfabetica");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lerJTableOrdemAlfabetica();
			}
		});
		button.setBounds(330, 65, 181, 31);
		pnlConsultar.add(button);
		
		
		JPanel lblCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, lblCadastrar, null);
		lblCadastrar.setLayout(null);
		
		txtNomeVend = new JTextField();
		txtNomeVend.setBounds(41, 56, 174, 29);
		lblCadastrar.add(txtNomeVend);
		txtNomeVend.setColumns(10);
		
		JLabel lblNomeVendedor = new JLabel("Nome Vendedor : ");
		lblNomeVendedor.setBounds(41, 31, 107, 14);
		lblCadastrar.add(lblNomeVendedor);
		
		JLabel lblTelefoneVendedor = new JLabel("Telefone Vendedor: ");
		lblTelefoneVendedor.setBounds(41, 161, 145, 14);
		lblCadastrar.add(lblTelefoneVendedor);
		
		txtTelVend = new JTextField();
		txtTelVend.setColumns(10);
		txtTelVend.setBounds(41, 186, 174, 29);
		lblCadastrar.add(txtTelVend);
		
		JLabel lblEmailVendedor = new JLabel("Email Vendedor :");
		lblEmailVendedor.setBounds(41, 226, 97, 14);
		lblCadastrar.add(lblEmailVendedor);
		
		txtEmlVnd = new JTextField();
		txtEmlVnd.setColumns(10);
		txtEmlVnd.setBounds(41, 251, 174, 29);
		lblCadastrar.add(txtEmlVnd);
		
		DefaultTableModel modelo = (DefaultTableModel) jTVend.getModel();
		//lerJTable();
		
		JLabel lblMetaMensal_1 = new JLabel("Meta Mensal : ");
		lblMetaMensal_1.setBounds(41, 291, 97, 14);
		lblCadastrar.add(lblMetaMensal_1);
		
		txtMetaMensal = new JTextField();
		txtMetaMensal.setColumns(10);
		txtMetaMensal.setBounds(41, 316, 174, 29);
		lblCadastrar.add(txtMetaMensal);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Vendedor v = new Vendedor();
				VendedorDAO vDAO = new VendedorDAO();
				
				v.setNome(txtNomeVend.getText());
				v.setCpf(txtCpfVnd.getText());
				v.setTelefones(txtTelVend.getText());
				v.setEmail(txtEmlVnd.getText());
				v.setMetaMensal(Double.parseDouble(txtMetaMensal.getText()));
				vDAO.create(v);

				txtNomeVend.setText("");
				txtCpfVnd.setText("");
				txtTelVend.setText("");
				txtEmlVnd.setText("");

				lerJTable();
			}
		});
		btnNewButton.setBounds(41, 356, 97, 29);
		lblCadastrar.add(btnNewButton);
		
		txtCpfVnd = new JTextField();
		txtCpfVnd.setColumns(10);
		txtCpfVnd.setBounds(41, 121, 174, 29);
		lblCadastrar.add(txtCpfVnd);
		
		JLabel lblCpfVendedor = new JLabel("Cpf Vendedor : ");
		lblCpfVendedor.setBounds(41, 96, 145, 14);
		lblCadastrar.add(lblCpfVendedor);
		
		JLabel lblClientes = new JLabel("Vendedor");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
		
		
	}
	/**
	 * Metodo popular tabela todos itens
	 * 
	 */
	
	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTVend.getModel();
		modelo.setNumRows(0);
		VendedorDAO vDAO = new VendedorDAO();

		for (Vendedor v : vDAO.read()) {
			modelo.addRow(new Object[] { v.getCodigo(), v.getNome(), v.getTelefones(), v.getCpf(), v.getEmail(), v.getDataCad(), v.getMetaMensal()

			});
		}

	}
	
	public void lerJTableOrdemAlfabetica() {
		DefaultTableModel modelo = (DefaultTableModel) jTVend.getModel();
		modelo.setNumRows(0);
		VendedorDAO vDAO = new VendedorDAO();

		for (Vendedor v : vDAO.imprimirOrdemAlfabetica()) {
			modelo.addRow(new Object[] { v.getCodigo(), v.getNome(), v.getTelefones(), v.getCpf(), v.getEmail(), v.getDataCad(), v.getMetaMensal()

			});
		}

	}
	
	
	/**
	 * Metodo popular tabela por CPF
	 * @param cpfVnd
	 */
	
	public void lerJTablePorCpf(String cpfVnd) {
		DefaultTableModel modelo = (DefaultTableModel) jTVend.getModel();
		modelo.setNumRows(0);
		VendedorDAO vDAO = new VendedorDAO();

		for (Vendedor v : vDAO.buscaPorCpf(cpfVnd)) {
			modelo.addRow(new Object[] { v.getCodigo(), v.getNome(), v.getTelefones(), v.getCpf(), v.getEmail(), v.getDataCad(), v.getMetaMensal()

			});
		}

	}
}
