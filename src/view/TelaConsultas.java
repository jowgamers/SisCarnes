package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CompraDAO;
import controller.DAOUtil;
import controller.VendaDAO;
import model.Compra;
import model.Estastiticas;
import model.Venda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaConsultas extends JPanel {
	private JTable tableVendas;
	private JTable table;
	private JTable tableEstatic;
	private JTextField txtData1;
	private JTextField txtData2;

	public TelaConsultas() {
		setBackground(new Color(48, 50, 61));
		setBounds(0, 0, 825, 555);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 825, 555);
		tabbedPane.setForeground(Color.WHITE);
		add(tabbedPane);
		
		JPanel pnlForne = new JPanel();
		pnlForne.setBackground(new Color(48, 50, 61));
		tabbedPane.addTab("Vendas", null, pnlForne, null);
		pnlForne.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 701, 419);
		pnlForne.add(scrollPane);
		
		tableVendas = new JTable();
		tableVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero Da Venda", "Codigo Vendedor", "Codigo Cliente", "Data Venda", "Forma de Pagamento", "Codigo Carrinho"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableVendas.getColumnModel().getColumn(0).setResizable(false);
		tableVendas.getColumnModel().getColumn(0).setPreferredWidth(110);
		tableVendas.getColumnModel().getColumn(1).setResizable(false);
		tableVendas.getColumnModel().getColumn(1).setPreferredWidth(106);
		tableVendas.getColumnModel().getColumn(2).setResizable(false);
		tableVendas.getColumnModel().getColumn(2).setPreferredWidth(99);
		tableVendas.getColumnModel().getColumn(3).setResizable(false);
		tableVendas.getColumnModel().getColumn(3).setPreferredWidth(94);
		tableVendas.getColumnModel().getColumn(4).setResizable(false);
		tableVendas.getColumnModel().getColumn(4).setPreferredWidth(128);
		tableVendas.getColumnModel().getColumn(5).setResizable(false);
		tableVendas.getColumnModel().getColumn(5).setPreferredWidth(115);
		
		DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
		//lerJTable();
		
		scrollPane.setViewportView(tableVendas);
		
		JButton btnNewButton = new JButton("Clientes por per\u00EDodo de vendas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerJTableOrdena("cod_cli");
			}
		});
		btnNewButton.setBounds(10, 56, 237, 34);
		pnlForne.add(btnNewButton);
		
		JButton btnVendedoresPorPerodo = new JButton("Vendedores por per\u00EDodo de vendas");
		btnVendedoresPorPerodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lerJTableOrdena("cod_vnd");
			}
		});
		btnVendedoresPorPerodo.setBounds(473, 56, 237, 34);
		pnlForne.add(btnVendedoresPorPerodo);
		
		JPanel pnlCompras = new JPanel();
		pnlCompras.setBackground(new Color(48, 50, 61));
		tabbedPane.addTab("Compras", null, pnlCompras, null);
		pnlCompras.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 120, 701, 419);
		pnlCompras.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero da Compra", "", "Codigo Fornecedor", "Data da Compra"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setMinWidth(4);
		table.getColumnModel().getColumn(2).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		scrollPane_1.setViewportView(table);
		
		
		DefaultTableModel modeloCompra = (DefaultTableModel) table.getModel();
		//lerJTableCompras();
		
		JButton btnFornecedoresPorPerodo = new JButton("Fornecedores por per\u00EDodo de compras");
		btnFornecedoresPorPerodo.setBounds(10, 56, 237, 34);
		pnlCompras.add(btnFornecedoresPorPerodo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(48, 50, 61));
		tabbedPane.addTab("New tab", null, panel, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 120, 701, 419);
		panel.add(scrollPane_2);
		
		tableEstatic = new JTable();
		tableEstatic.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Qntde", "Valor Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEstatic.getColumnModel().getColumn(1).setPreferredWidth(92);
		scrollPane_2.setViewportView(tableEstatic);
		
		JButton button = new JButton("Estasticas Vendedores");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerJTableEstaVende(txtData1.getText(), txtData2.getText());
			}
		});
		button.setBounds(284, 11, 163, 34);
		panel.add(button);
		
		JButton button_1 = new JButton("Estasticas Clientes");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerJTableEsta(txtData1.getText(), txtData2.getText());
			}
		});
		button_1.setBounds(284, 56, 163, 34);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Fornecedores por per\u00EDodo de compras");
		button_2.setBounds(457, 56, 163, 34);
		panel.add(button_2);
		
		txtData1 = new JTextField();
		txtData1.setBounds(20, 56, 76, 34);
		panel.add(txtData1);
		txtData1.setColumns(10);
		
		txtData2 = new JTextField();
		txtData2.setColumns(10);
		txtData2.setBounds(123, 56, 76, 34);
		panel.add(txtData2);
		
		JLabel lblPeriodoDoRelatorio = new JLabel("Periodo do relatorio");
		lblPeriodoDoRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeriodoDoRelatorio.setForeground(Color.WHITE);
		lblPeriodoDoRelatorio.setBounds(10, 31, 163, 14);
		panel.add(lblPeriodoDoRelatorio);
		
		JLabel label = new JLabel("\u00E0");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(106, 65, 16, 14);
		panel.add(label);
	}
	
	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
		modelo.setNumRows(0);
		VendaDAO vDAO = new VendaDAO();

		for (Venda v : vDAO.read()) {
			modelo.addRow(new Object[] { v.getNumVenda(), v.getVendedor(), v.getCliente(), v.getDataVenda(), v.getDataVenda(),
					v.getFormaPagto(), v.getIdItemVenda()

			});
		}

	}
	
	public void lerJTableCompras() {
		DefaultTableModel modeloCompra = (DefaultTableModel) table.getModel();
		modeloCompra.setNumRows(0);
		CompraDAO cDAO = new CompraDAO();

		for (Compra c : cDAO.read()) {
			modeloCompra.addRow(new Object[] { c.getNumCompra(), "" ,c.getFornecedor(), c.getDataCompra()
			});
		}

	}
	
	public void lerJTableOrdena(String concatena) {
		DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
		modelo.setNumRows(0);
		VendaDAO vDAO = new VendaDAO();

		for (Venda v : vDAO.readPorPeriodoOrdemCliente(concatena)) {
			modelo.addRow(new Object[] { v.getNumVenda(), v.getVendedor(), v.getCliente(), v.getDataVenda(), v.getDataVenda(),
					v.getFormaPagto(), v.getIdItemVenda()

			});
		}

	}
	
	public void lerJTableEsta(String data1, String data2) {
		DefaultTableModel modelo = (DefaultTableModel) tableEstatic.getModel();
		modelo.setNumRows(0);
		DAOUtil dDAO = new DAOUtil();

		for (Estastiticas es : dDAO.readClienteData(data1, data2)) {
			modelo.addRow(new Object[] {es.getNome(), es.getQntde(), es.getValor()
			});
		}

	}

	
	public void lerJTableEstaVende(String data1, String data2) {
		DefaultTableModel modelo = (DefaultTableModel) tableEstatic.getModel();
		modelo.setNumRows(0);
		DAOUtil dDAO = new DAOUtil();

		for (Estastiticas es : dDAO.readVendedorData(data1, data2)) {
			modelo.addRow(new Object[] {es.getNome(), es.getQntde(), es.getValor()
			});
		}

	}
	
}
