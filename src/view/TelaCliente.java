package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ClienteDAO;
import controller.CompraDAO;
import controller.FornecedorDAO;
import controller.ItemCompraDAO;
import controller.ItemVendaDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import controller.VendedorDAO;
import model.Cliente;
import model.Compra;
import model.Fornecedor;
import model.ItemCompra;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import model.Vendedor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TelaCliente extends JPanel {

	private JTextField txtNomeVend;
	private JTextField txtTelVend;
	private JTextField txtEmlVnd;
	private JTextField txtMetaMensal;
	private JTextField txtCpfVnd;
	private JTable jTCli;
	private JTextField txtCNome;
	private JTextField txtCCpf;
	private JTextField txtCTel;
	private JTextField txtCEmail;
	private JTextField txtCLmtCred;
	
	private JTextField txtNomCnt;
	private JTextField txtQntde;
	private JTable jTCarri;
	private JTextField txtNumCompra;
	private JComboBox comboBProd;
	private JComboBox comboBoxCmp;
	private JComboBox comboCli;
	private JComboBox comboVnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnAVista;
	private JRadioButton rdbtnAPrazo;
	private JTextField txtBuscaNome;

	/**
	 * Create the panel.
	 */
	public TelaCliente() {
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
				if (jTCli.getSelectedRow() != -1) {

					Cliente c = new Cliente();
					ClienteDAO cDAO = new ClienteDAO();
					c.setNome(txtCNome.getText());
					c.setCpf(txtCCpf.getText());
					c.setEmail(txtCEmail.getText());
					c.setLimiteCredito(Double.parseDouble(txtCLmtCred.getText()));
					c.setTelefones(txtCTel.getText());
					c.setCodigo((int) jTCli.getValueAt(jTCli.getSelectedRow(), 0));
					
					cDAO.update(c);

					txtNomeVend.setText("");
					txtCLmtCred.setText("");
					txtCpfVnd.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					lerJTable();

				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnAtualizar.setBounds(675, 11, 75, 23);
		pnlConsultar.add(btnAtualizar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 800, 355);
		pnlConsultar.add(scrollPane);

		
		jTCli = new JTable();
		jTCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTCli.getSelectedRow() != -1) {
					
					txtCNome.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 1).toString());
					txtCTel.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 2).toString());
					txtCCpf.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 3).toString());
					txtCEmail.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 4).toString());
					txtCLmtCred.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 6).toString());

				}
			}
		});
		jTCli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Cliente", "Nome", "Telefone", "Cpf", "Email", "Data Cadastro", "Limite Credito"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTCli);
		
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
		
		JLabel lblMetaMs = new JLabel("Limite Credito: ");
		lblMetaMs.setBounds(572, 11, 108, 14);
		pnlConsultar.add(lblMetaMs);
		
		txtCLmtCred = new JTextField();
		txtCLmtCred.setColumns(10);
		txtCLmtCred.setBounds(571, 25, 94, 29);
		pnlConsultar.add(txtCLmtCred);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTCli.getSelectedRow() != -1) {

					Cliente c = new Cliente();
					ClienteDAO cDAO = new ClienteDAO();

					c.setCodigo((int) jTCli.getValueAt(jTCli.getSelectedRow(), 0));

					cDAO.delete(c);

					txtNomeVend.setText("");
					txtCpfVnd.setText("");
					txtCLmtCred.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					lerJTable();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir.setBounds(675, 40, 75, 23);
		pnlConsultar.add(btnExcluir);
		
		JButton btnBuscarPorCpf = new JButton("Buscar por CPF");
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lerJTablePorCpf(txtBuscaNome.getText());
				
			}
		});
		btnBuscarPorCpf.setBounds(170, 59, 149, 31);
		pnlConsultar.add(btnBuscarPorCpf);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setBounds(10, 59, 149, 31);
		pnlConsultar.add(txtBuscaNome);
		
		JButton btnImprimeOrdemAlfabetica = new JButton("Imprime Ordem Alfabetica");
		btnImprimeOrdemAlfabetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lerJTableOrdemAlfabetica();
				
			}
		});
		btnImprimeOrdemAlfabetica.setBounds(329, 59, 181, 31);
		pnlConsultar.add(btnImprimeOrdemAlfabetica);
		
		
		JPanel lblCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, lblCadastrar, null);
		lblCadastrar.setLayout(null);
		
		txtNomeVend = new JTextField();
		txtNomeVend.setBounds(41, 56, 174, 29);
		lblCadastrar.add(txtNomeVend);
		txtNomeVend.setColumns(10);
		
		JLabel lblNomeCli = new JLabel("Nome Cliente : ");
		lblNomeCli.setBounds(41, 31, 107, 14);
		lblCadastrar.add(lblNomeCli);
		
		JLabel lblTelefoneCli = new JLabel("Telefone Cliente: ");
		lblTelefoneCli.setBounds(41, 161, 145, 14);
		lblCadastrar.add(lblTelefoneCli);
		
		txtTelVend = new JTextField();
		txtTelVend.setColumns(10);
		txtTelVend.setBounds(41, 186, 174, 29);
		lblCadastrar.add(txtTelVend);
		
		JLabel lblEmailCliente = new JLabel("Email Cliente :");
		lblEmailCliente.setBounds(41, 226, 97, 14);
		lblCadastrar.add(lblEmailCliente);
		
		txtEmlVnd = new JTextField();
		txtEmlVnd.setColumns(10);
		txtEmlVnd.setBounds(41, 251, 174, 29);
		lblCadastrar.add(txtEmlVnd);
		
		JLabel lblMetaMensal_1 = new JLabel("Limite Credito : ");
		lblMetaMensal_1.setBounds(41, 291, 97, 14);
		lblCadastrar.add(lblMetaMensal_1);
		
		txtMetaMensal = new JTextField();
		txtMetaMensal.setColumns(10);
		txtMetaMensal.setBounds(41, 316, 174, 29);
		lblCadastrar.add(txtMetaMensal);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente c = new Cliente();
				ClienteDAO cDAO = new ClienteDAO();
				
				c.setNome(txtNomeVend.getText());
				c.setCpf(txtCpfVnd.getText());
				c.setTelefones(txtTelVend.getText());
				c.setEmail(txtEmlVnd.getText());
				c.setLimiteCredito(Double.parseDouble(txtMetaMensal.getText()));
				cDAO.create(c);

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
		
		JLabel lblCpfCliente = new JLabel("Cpf Cliente : ");
		lblCpfCliente.setBounds(41, 96, 145, 14);
		lblCadastrar.add(lblCpfCliente);
		
		
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		//lerJTable();
		
		
		
		
		
		
		
		
		
		JPanel lblVenda = new JPanel();
		tabbedPane.addTab("Vender", null, lblVenda, null);
		lblVenda.setLayout(null);

		JLabel lblNewLabel = new JLabel("Item Venda");
		lblNewLabel.setBounds(10, 18, 122, 14);
		lblVenda.add(lblNewLabel);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 43, 133, 14);
		lblVenda.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(230, 43, 67, 14);
		lblVenda.add(lblQuantidade);

		comboBProd = new JComboBox();
		comboBProd.setBounds(10, 57, 133, 31);
		lblVenda.add(comboBProd);

		txtQntde = new JTextField();
		txtQntde.setBounds(230, 57, 67, 31);
		lblVenda.add(txtQntde);
		txtQntde.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar no Carrinho");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ItemVenda iv = new ItemVenda();
				ItemVendaDAO ivDAO = new ItemVendaDAO();
				ProdutoDAO pDAO = new ProdutoDAO();
				int codProd; // Var temporaria para usar o metodo criado na Produto

				codProd = pDAO.buscaNomeRetornaCodigo(comboBProd.getSelectedItem().toString());
				iv.setProduto(codProd);
				iv.setCompraFinalizada("N");
				iv.setQuantVenda(Integer.parseInt(txtQntde.getText()));
				iv.setValorVenda(ivDAO.calculaVlr(Integer.parseInt(txtQntde.getText()),codProd)); // Preco prod * qntde

				ivDAO.create(iv);

				txtQntde.setText("");

				lerJTableItemVenda();

			}
		});
		btnAdicionar.setBounds(373, 57, 166, 31);
		lblVenda.add(btnAdicionar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 100, 820, 2);
		lblVenda.add(separator);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (jTCarri.getSelectedRow() != -1) {
					ItemVenda iv = new ItemVenda();
					ItemVendaDAO ivDAO = new ItemVendaDAO();

					iv.setCodVenda((int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 0));

					ivDAO.delete(iv);

					lerJTableItemVenda();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir_1.setBounds(549, 57, 89, 31);
		lblVenda.add(btnExcluir_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 113, 800, 171);
		lblVenda.add(scrollPane_1);

		jTCarri = new JTable();
		jTCarri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jTCarri.getSelectedRow() != -1) {

					txtNumCompra.setText(jTCarri.getValueAt(jTCarri.getSelectedRow(), 0).toString());
					txtQntde.setText(jTCarri.getValueAt(jTCarri.getSelectedRow(), 2).toString());
				}

			}
		});
		jTCarri.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero Venda", "Codigo Produto", "Quantidade Compra", "Valor Compra", "Compra Finalizada"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTCarri.getColumnModel().getColumn(0).setResizable(false);
		jTCarri.getColumnModel().getColumn(1).setResizable(false);
		jTCarri.getColumnModel().getColumn(1).setPreferredWidth(90);
		jTCarri.getColumnModel().getColumn(1).setMinWidth(90);
		jTCarri.getColumnModel().getColumn(2).setResizable(false);
		jTCarri.getColumnModel().getColumn(2).setPreferredWidth(85);
		jTCarri.getColumnModel().getColumn(2).setMinWidth(85);
		jTCarri.getColumnModel().getColumn(3).setResizable(false);
		jTCarri.getColumnModel().getColumn(3).setMinWidth(75);
		jTCarri.getColumnModel().getColumn(4).setResizable(false);
		jTCarri.getColumnModel().getColumn(4).setPreferredWidth(80);
		jTCarri.getColumnModel().getColumn(4).setMinWidth(80);
		scrollPane_1.setViewportView(jTCarri);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Venda v = new Venda();
				VendaDAO vDAO = new VendaDAO();
				ClienteDAO cliDAO = new ClienteDAO();
				VendedorDAO vndDAO = new VendedorDAO();
				int codProd = 0; // Tmp pro codigo do produto usado abaixo

				if (vDAO.cmpFinalizada((int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 0))) {

					int codCli; // Var temporaria para usar o metodo criado na cliente
					codCli = cliDAO.buscaNomeRetornaCodigo((String) comboCli.getSelectedItem());
					v.setCliente(codCli);
				
					int codVnd; // Var temporaria para usar o metodo criado na Produto
					codVnd = vndDAO.buscaNomeRetornaCodigo((String) comboVnd.getSelectedItem());
					v.setVendedor(codVnd);
					
					//Radio Button da forma de pgto
					int formaPagto = 0;
					if(rdbtnAVista.isSelected()) 
						formaPagto= 1 ;
					else if(rdbtnAPrazo.isSelected()) 
						formaPagto= 2 ;
					v.setFormaPagto(formaPagto);
					
					//Num carrinho
					v.setNumVenda(Integer.parseInt(txtNumCompra.getText()));
					
					//Salva no BD
					vDAO.create(v);
					
					vDAO.updateCmpFnl(Integer.parseInt(txtNumCompra.getText()));
					codProd = (int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 1);
					vDAO.updEstoq(codProd, Integer.parseInt(txtQntde.getText()));

					txtQntde.setText("");
					lerJTableItemVenda();

				} else {
					JOptionPane.showMessageDialog(null, "Compra ja finalizada", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				lerJTable();

			}
		});
		btnFinalizar.setBounds(573, 316, 89, 31);
		lblVenda.add(btnFinalizar);


		DefaultTableModel modeloItemCompra = (DefaultTableModel) jTCarri.getModel();
		//lerJTableItemVenda();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 295, 820, 2);
		lblVenda.add(separator_1);

		JLabel lblNumCompra = new JLabel("Num Carrinho : ");
		lblNumCompra.setBounds(296, 302, 90, 14);
		lblVenda.add(lblNumCompra);

		txtNumCompra = new JTextField();
		txtNumCompra.setEditable(false);
		txtNumCompra.setColumns(10);
		txtNumCompra.setBounds(296, 316, 67, 31);
		lblVenda.add(txtNumCompra);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 358, 820, 2);
		lblVenda.add(separator_2);

		comboBoxCmp = new JComboBox();
		comboBoxCmp.setBounds(10, 387, 133, 31);
		lblVenda.add(comboBoxCmp);

		JLabel lblNumCompra_1 = new JLabel("Num  Venda");
		lblNumCompra_1.setBounds(10, 373, 101, 14);
		lblVenda.add(lblNumCompra_1);

		JButton btnExcluirCompra = new JButton("Excluir Compra");
		btnExcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxCmp.getSelectedIndex() != -1) {

					Venda v = new Venda();
					VendaDAO vDAO = new VendaDAO();
					v.setNumVenda((int)comboBoxCmp.getSelectedItem());

					vDAO.delete(v);
					populaBoxCmp();
				}
			}

		});
		btnExcluirCompra.setBounds(153, 387, 133, 31);
		lblVenda.add(btnExcluirCompra);
		
		JLabel Cliente = new JLabel("Cliente");
		Cliente.setBounds(10, 303, 133, 14);
		lblVenda.add(Cliente);
		
		comboCli = new JComboBox();
		comboCli.setBounds(10, 317, 133, 31);
		lblVenda.add(comboCli);
		
		JLabel lblVendedore = new JLabel("Vendedor");
		lblVendedore.setBounds(153, 302, 133, 14);
		lblVenda.add(lblVendedore);
		
		comboVnd = new JComboBox();
		comboVnd.setBounds(153, 316, 133, 31);
		lblVenda.add(comboVnd);
		
		JLabel lblFormaPgto = new JLabel("Forma Pgto : ");
		lblFormaPgto.setBounds(396, 302, 122, 14);
		lblVenda.add(lblFormaPgto);
		
		rdbtnAVista = new JRadioButton("A vista");
		buttonGroup.add(rdbtnAVista);
		rdbtnAVista.setBounds(396, 320, 67, 23);
		lblVenda.add(rdbtnAVista);
		
		rdbtnAPrazo = new JRadioButton("A prazo");
		buttonGroup.add(rdbtnAPrazo);
		rdbtnAPrazo.setBounds(468, 320, 63, 23);
		lblVenda.add(rdbtnAPrazo);
		/*populaBoxCli();
		populaBoxProd();
		populaBoxCmp();
		populaBoxVnd();*/
		
		JLabel lblClientes = new JLabel("Clientes : ");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
		
		
	}
	
	private void populaBoxCli() {
		ClienteDAO cliDAO = new ClienteDAO();
		List<Cliente> lista = cliDAO.read();
		comboCli.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboCli.addItem(new String (lista.get(i).getNome()));
		}
	}

	private void populaBoxCmp() {
		VendaDAO vndDAO = new VendaDAO();
		comboBoxCmp.removeAllItems();
		List<Venda> lista = vndDAO.read();
		comboBoxCmp.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboBoxCmp.addItem(lista.get(i).getNumVenda());
		}
	}
	
	private void populaBoxVnd() {
		VendedorDAO vndDAO = new VendedorDAO();
		comboVnd.removeAllItems();
		List<Vendedor> lista = vndDAO.read();
		comboVnd.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboVnd.addItem(lista.get(i).getNome());
		}
	}

	private void populaBoxProd() {
		ProdutoDAO prdDAO = new ProdutoDAO();
		List<Produto> lista = prdDAO.read();
		comboBProd.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboBProd.addItem(lista.get(i).getNome());
		}
	}
	
	
	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();

		for (Cliente c : cDAO.read()) {
			modelo.addRow(new Object[] { c.getCodigo(), c.getNome(),  c.getCpf(),c.getTelefones(), c.getEmail(), c.getDataCad(), c.getLimiteCredito()

			});
		}

	}
	
	public void lerJTableOrdemAlfabetica() {
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();

		for (Cliente c : cDAO.imprimirOrdemAlfabetica()) {
			modelo.addRow(new Object[] { c.getCodigo(), c.getNome(),  c.getCpf(),c.getTelefones(), c.getEmail(), c.getDataCad(), c.getLimiteCredito()

			});
		}

	}
	
	public void lerJTableItemVenda() {
		DefaultTableModel modeloItemCompra = (DefaultTableModel) jTCarri.getModel();
		modeloItemCompra.setNumRows(0);
		ItemVendaDAO ivDAO = new ItemVendaDAO();

		for (ItemVenda iv : ivDAO.read()) {
			modeloItemCompra.addRow(new Object[] { iv.getCodVenda(), iv.getProduto(), iv.getQuantVenda(), iv.getValorVenda(), iv.getCompraFinalizada()

			});
		}

	}
	
	public void lerJTablePorCpf(String cpfCli) {
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();

		for (Cliente c : cDAO.buscaPorCpf(cpfCli)) {
			modelo.addRow(new Object[] { c.getCodigo(), c.getNome(), c.getTelefones(), c.getEmail(), c.getDataCad(), c.getCpf(), c.getLimiteCredito()

			});
		}

	}
}
