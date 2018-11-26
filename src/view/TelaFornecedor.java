package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.CompraDAO;
import controller.FornecedorDAO;
import controller.ItemCompraDAO;
import controller.ProdutoDAO;
import model.Compra;
import model.Fornecedor;
import model.ItemCompra;
import model.Produto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class TelaFornecedor extends JPanel {
	private JTextField txtNomeFor;
	private JTextField txtTelFrn;
	private JTextField txtEmlVnd;
	private JTextField txtMetaMensal;
	private JTextField txtCpfFrn;
	private JTable jTFor;
	private JTextField txtCNome;
	private JTextField txtCCpf;
	private JTextField txtCTel;
	private JTextField txtCEmail;
	private JTextField txtNomCnt;
	private JTextField txtQntde;
	private JTable jTCarri;
	private JComboBox comboBFrn;
	private JTextField txtNumCompra;
	private JComboBox comboBProd;
	private JComboBox comboBoxCmp;
	private JTextField txtBuscaNome;

	/**
	 * Create the panel.
	 */
	public TelaFornecedor() {
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
				if (jTFor.getSelectedRow() != -1) {

					Fornecedor v = new Fornecedor();
					FornecedorDAO vDAO = new FornecedorDAO();
					v.setNome(txtCNome.getText());
					v.setCnpj(txtCCpf.getText());
					v.setEmail(txtCEmail.getText());
					v.setNomeContato(txtNomCnt.getText());
					v.setTelefones(txtCTel.getText());
					v.setCodigo((int) jTFor.getValueAt(jTFor.getSelectedRow(), 0));

					vDAO.update(v);

					txtNomeFor.setText("");
					txtCpfFrn.setText("");
					txtTelFrn.setText("");
					txtEmlVnd.setText("");

					lerJTable();

				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnAtualizar.setBounds(675, 25, 75, 23);
		pnlConsultar.add(btnAtualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 800, 344);
		pnlConsultar.add(scrollPane);

		jTFor = new JTable();
		jTFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTFor.getSelectedRow() != -1) {

					txtCNome.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 1).toString());
					txtCTel.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 2).toString());
					txtCCpf.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 3).toString());
					txtCEmail.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 4).toString());
					txtNomCnt.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 6).toString());

				}
			}
		});
		jTFor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo Fornecedor", "Nome", "Telefone",
				"Cpf", "Email", "Data Cadastro", "Meta Mensal" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTFor);

		txtCNome = new JTextField();
		txtCNome.setBounds(9, 25, 150, 29);
		pnlConsultar.add(txtCNome);
		txtCNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 11, 46, 14);
		pnlConsultar.add(lblNome);

		JLabel lblCpf = new JLabel("CNPJ : ");
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

		JLabel lblMetaMs = new JLabel("Nome Contato : ");
		lblMetaMs.setBounds(572, 11, 110, 14);
		pnlConsultar.add(lblMetaMs);

		txtNomCnt = new JTextField();
		txtNomCnt.setColumns(10);
		txtNomCnt.setBounds(571, 25, 94, 29);
		pnlConsultar.add(txtNomCnt);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTFor.getSelectedRow() != -1) {

					Fornecedor v = new Fornecedor();
					FornecedorDAO vDAO = new FornecedorDAO();

					v.setCodigo((int) jTFor.getValueAt(jTFor.getSelectedRow(), 0));

					vDAO.delete(v);

					txtNomeFor.setText("");
					txtCpfFrn.setText("");
					txtTelFrn.setText("");
					txtEmlVnd.setText("");

					lerJTable();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir.setBounds(675, 54, 75, 23);
		pnlConsultar.add(btnExcluir);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setBounds(10, 70, 164, 31);
		pnlConsultar.add(txtBuscaNome);
		
		JButton btnBuscarPorCnpj = new JButton("Buscar por CNPJ");
		btnBuscarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerJTablePorCnpj(txtBuscaNome.getText());
			}
		});
		btnBuscarPorCnpj.setBounds(184, 70, 140, 31);
		pnlConsultar.add(btnBuscarPorCnpj);
		
		JButton btnImprimirEmOrdem = new JButton("Imprimir em ordem Alfabetica");
		btnImprimirEmOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lerJTableOrdemAlfabetica();
			}
		});
		btnImprimirEmOrdem.setBounds(330, 70, 192, 31);
		pnlConsultar.add(btnImprimirEmOrdem);

		JPanel lblCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, lblCadastrar, null);
		lblCadastrar.setLayout(null);

		txtNomeFor = new JTextField();
		txtNomeFor.setBounds(41, 56, 174, 29);
		lblCadastrar.add(txtNomeFor);
		txtNomeFor.setColumns(10);

		JLabel lblNomeFornecedor = new JLabel("Nome Fornecedor : ");
		lblNomeFornecedor.setBounds(41, 31, 174, 14);
		lblCadastrar.add(lblNomeFornecedor);

		JLabel lblTelefoneFornecedor = new JLabel("Telefone Fornecedor: ");
		lblTelefoneFornecedor.setBounds(41, 161, 145, 14);
		lblCadastrar.add(lblTelefoneFornecedor);

		txtTelFrn = new JTextField();
		txtTelFrn.setColumns(10);
		txtTelFrn.setBounds(41, 186, 174, 29);
		lblCadastrar.add(txtTelFrn);

		JLabel lblEmailFornecedor = new JLabel("Email Fornecedor :");
		lblEmailFornecedor.setBounds(41, 226, 174, 14);
		lblCadastrar.add(lblEmailFornecedor);

		txtEmlVnd = new JTextField();
		txtEmlVnd.setColumns(10);
		txtEmlVnd.setBounds(41, 251, 174, 29);
		lblCadastrar.add(txtEmlVnd);

		JLabel lblMetaMensal_1 = new JLabel("Contato do Fornecedor : ");
		lblMetaMensal_1.setBounds(41, 291, 174, 14);
		lblCadastrar.add(lblMetaMensal_1);

		txtMetaMensal = new JTextField();
		txtMetaMensal.setColumns(10);
		txtMetaMensal.setBounds(41, 316, 174, 29);
		lblCadastrar.add(txtMetaMensal);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Fornecedor v = new Fornecedor();
				FornecedorDAO vDAO = new FornecedorDAO();

				v.setNome(txtNomeFor.getText());
				v.setCnpj(txtCpfFrn.getText());
				v.setTelefones(txtTelFrn.getText());
				v.setEmail(txtEmlVnd.getText());
				v.setNomeContato(txtMetaMensal.getText());
				vDAO.create(v);

				txtNomeFor.setText("");
				txtCpfFrn.setText("");
				txtTelFrn.setText("");
				txtEmlVnd.setText("");

				lerJTable();
			}
		});
		btnNewButton.setBounds(41, 356, 97, 29);
		lblCadastrar.add(btnNewButton);

		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		//lerJTable();
		
		txtCpfFrn = new JTextField();
		txtCpfFrn.setColumns(10);
		txtCpfFrn.setBounds(41, 121, 174, 29);
		lblCadastrar.add(txtCpfFrn);

		JLabel lblCpfFornecedor = new JLabel("Cnpj Fornecedor : ");
		lblCpfFornecedor.setBounds(41, 96, 145, 14);
		lblCadastrar.add(lblCpfFornecedor);

		JPanel lblCompra = new JPanel();
		tabbedPane.addTab("Compra", null, lblCompra, null);
		lblCompra.setLayout(null);

		JLabel lblNewLabel = new JLabel("Item Compra\r\n");
		lblNewLabel.setBounds(10, 18, 122, 14);
		lblCompra.add(lblNewLabel);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 43, 46, 14);
		lblCompra.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(173, 43, 67, 14);
		lblCompra.add(lblQuantidade);

		comboBProd = new JComboBox();
		comboBProd.setBounds(10, 57, 133, 31);
		lblCompra.add(comboBProd);

		txtQntde = new JTextField();
		txtQntde.setBounds(173, 57, 67, 31);
		lblCompra.add(txtQntde);
		txtQntde.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar no Carrinho");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ItemCompra ic = new ItemCompra();
				ItemCompraDAO icDAO = new ItemCompraDAO();
				ProdutoDAO pDAO = new ProdutoDAO();
				int codProd; // Var temporaria para usar o metodo criado na Produto

				codProd = pDAO.buscaNomeRetornaCodigo(comboBProd.getSelectedItem().toString());
				System.out.println(codProd);
				ic.setProduto(codProd);
				ic.setCompraFinalizada("N");
				ic.setQuantCompra(Integer.parseInt(txtQntde.getText()));
				ic.setValorCompra(icDAO.calculaVlr(Integer.parseInt(txtQntde.getText()),codProd)); // Preco prod * qntde

				icDAO.create(ic);

				txtQntde.setText("");

				lerJTableItemCompra();

			}
		});
		btnAdicionar.setBounds(274, 57, 184, 31);
		lblCompra.add(btnAdicionar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 100, 820, 2);
		lblCompra.add(separator);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (jTCarri.getSelectedRow() != -1) {
					ItemCompra ic = new ItemCompra();
					ItemCompraDAO icDAO = new ItemCompraDAO();

					ic.setCodCompra((int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 0));

					icDAO.delete(ic);

					lerJTableItemCompra();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir_1.setBounds(468, 57, 89, 31);
		lblCompra.add(btnExcluir_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 113, 800, 171);
		lblCompra.add(scrollPane_1);

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
		jTCarri.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero Compra", "Codigo Produto",
				"Qntd Compra", "Valor Compra", "Compra Finalizada" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTCarri.getColumnModel().getColumn(1).setPreferredWidth(90);
		jTCarri.getColumnModel().getColumn(1).setMinWidth(90);
		jTCarri.getColumnModel().getColumn(2).setPreferredWidth(85);
		jTCarri.getColumnModel().getColumn(2).setMinWidth(85);
		jTCarri.getColumnModel().getColumn(3).setMinWidth(75);
		jTCarri.getColumnModel().getColumn(4).setPreferredWidth(80);
		jTCarri.getColumnModel().getColumn(4).setMinWidth(80);
		scrollPane_1.setViewportView(jTCarri);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Compra c = new Compra();
				CompraDAO cDAO = new CompraDAO();
				FornecedorDAO fDAO = new FornecedorDAO();
				int codProd = 0; // Tmp pro codigo do produto usado abaixo

				if (cDAO.cmpFinalizada((int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 0))) {

					int codFrn; // Var temporaria para usar o metodo criado na Produto
					codFrn = fDAO.buscaNomeRetornaCodigo((String) comboBFrn.getSelectedItem());
					c.setFornecedor(codFrn);
					c.setNumCompra(Integer.parseInt(txtNumCompra.getText()));
					cDAO.create(c);
					cDAO.updateCmpFnl(Integer.parseInt(txtNumCompra.getText()));
					codProd = (int) jTCarri.getValueAt(jTCarri.getSelectedRow(), 1);
					cDAO.updEstoq(codProd, Integer.parseInt(txtQntde.getText()));

					txtQntde.setText("");
					lerJTableItemCompra();

				} else {
					JOptionPane.showMessageDialog(null, "Compra ja finalizada", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				lerJTable();

			}
		});
		btnFinalizar.setBounds(230, 317, 89, 31);
		lblCompra.add(btnFinalizar);


		DefaultTableModel modeloItemCompra = (DefaultTableModel) jTCarri.getModel();
		//lerJTableItemCompra();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 295, 820, 2);
		lblCompra.add(separator_1);

		comboBFrn = new JComboBox();
		comboBFrn.setBounds(10, 317, 133, 31);
		lblCompra.add(comboBFrn);

		JLabel lblNumCompra = new JLabel("Num Carrinho : ");
		lblNumCompra.setBounds(153, 303, 80, 14);
		lblCompra.add(lblNumCompra);

		txtNumCompra = new JTextField();
		txtNumCompra.setEditable(false);
		txtNumCompra.setColumns(10);
		txtNumCompra.setBounds(153, 317, 67, 31);
		lblCompra.add(txtNumCompra);

		JLabel lblNumFornecedor = new JLabel("Num Fornecedor : ");
		lblNumFornecedor.setBounds(10, 303, 101, 14);
		lblCompra.add(lblNumFornecedor);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 358, 820, 2);
		lblCompra.add(separator_2);

		comboBoxCmp = new JComboBox();
		comboBoxCmp.setBounds(10, 387, 133, 31);
		lblCompra.add(comboBoxCmp);

		JLabel lblNumCompra_1 = new JLabel("Num Compra : ");
		lblNumCompra_1.setBounds(10, 373, 101, 14);
		lblCompra.add(lblNumCompra_1);

		JButton btnExcluirCompra = new JButton("Excluir Compra");
		btnExcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxCmp.getSelectedIndex() != -1) {

					Compra c = new Compra();
					CompraDAO cDAO = new CompraDAO();
					System.out.println((int)comboBoxCmp.getSelectedItem());
					c.setNumCompra((int)comboBoxCmp.getSelectedItem());

					cDAO.delete(c);
					populaBoxCmp();
				}
			}

		});
		btnExcluirCompra.setBounds(153, 387, 133, 31);
		lblCompra.add(btnExcluirCompra);
		/*
		
		populaBoxFrn();//Metodo não testado
		populaBoxProd();//Metodo não testado
		populaBoxCmp();
		*/
		

		JLabel lblClientes = new JLabel("Fornecedor");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);

	}

	private void populaBoxFrn() {
		FornecedorDAO frnDAO = new FornecedorDAO();
		List<Fornecedor> lista = frnDAO.read();
		comboBFrn.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboBFrn.addItem(new String (lista.get(i).getNome()));
		}
	}

	private void populaBoxCmp() {
		CompraDAO cmpDAO = new CompraDAO();
		comboBoxCmp.removeAllItems();
		List<Compra> lista = cmpDAO.read();
		comboBoxCmp.addItem("");
		for (int i = 0; i < lista.size(); i++) {
			comboBoxCmp.addItem(lista.get(i).getNumCompra());
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
		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		modelo.setNumRows(0);
		FornecedorDAO vDAO = new FornecedorDAO();

		for (Fornecedor f : vDAO.read()) {
			modelo.addRow(new Object[] { f.getCodigo(), f.getNome(), f.getTelefones(), f.getCnpj(), f.getEmail(),
					f.getDataCad(), f.getNomeContato()

			});
		}

	}
	
	public void lerJTableOrdemAlfabetica() {
		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		modelo.setNumRows(0);
		FornecedorDAO vDAO = new FornecedorDAO();

		for (Fornecedor f : vDAO.imprimirOrdemAlfabetica()) {
			modelo.addRow(new Object[] { f.getCodigo(), f.getNome(), f.getTelefones(), f.getCnpj(), f.getEmail(),
					f.getDataCad(), f.getNomeContato()

			});
		}

	}
	
	public void lerJTableItemCompra() {
		DefaultTableModel modeloItemCompra = (DefaultTableModel) jTCarri.getModel();
		modeloItemCompra.setNumRows(0);
		ItemCompraDAO icDAO = new ItemCompraDAO();

		for (ItemCompra ic : icDAO.read()) {
			modeloItemCompra.addRow(new Object[] { ic.getCodCompra(), ic.getProduto(), ic.getQuantCompra(), ic.getValorCompra(), ic.getCompraFinalizada()

			});
		}

	}

	public void lerJTablePorCnpj(String cnpjFrn) {
		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		modelo.setNumRows(0);
		FornecedorDAO fDAO = new FornecedorDAO();

		for (Fornecedor f : fDAO.buscaPorCnpjFrn(cnpjFrn)) {
			modelo.addRow(new Object[] { f.getCodigo(), f.getNome(), f.getTelefones(), f.getCnpj(), f.getEmail(),
					f.getDataCad(), f.getNomeContato()

			});
		}

	}
}
