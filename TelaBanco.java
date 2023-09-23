package bancoAvocado;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;

public class TelaBanco {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNome;
	private JTextField textFieldSaldo;
	private JTextField textFieldAgencia;
	private JTextField textFieldConta;
	private Conta conta;
	private ContaPF conta_PF;
	private ContaPJ conta_PJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBanco window = new TelaBanco();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBanco() {
		initialize();
	    conta = new Conta();
	    conta_PF = new ContaPF();
	    conta_PJ = new ContaPJ();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Banco");
		lblNewLabel.setBounds(144, 0, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 327, 52);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Agência", "Conta", "Tipo Conta", "Nome", "Saldo"}));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Tipo Conta:");
		lblNewLabel_1.setBounds(163, 199, 66, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(11, 99, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(52, 96, 220, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Agência");
		lblNewLabel_3.setBounds(10, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnPJ = new JRadioButton("PJ");
		rdbtnPJ.setBounds(226, 195, 46, 23);
		frame.getContentPane().add(rdbtnPJ);

		JRadioButton rdbtnPF = new JRadioButton("PF");
		rdbtnPF.setBounds(280, 195, 57, 23);
		frame.getContentPane().add(rdbtnPF);

		JLabel lblNewLabel_4 = new JLabel("Conta");
		lblNewLabel_4.setBounds(87, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Saldo:");
		lblNewLabel_5.setBounds(10, 131, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);


		JButton btnCriar = new JButton("Criar");
		btnCriar.setForeground(new Color(0, 255, 0));
		btnCriar.setBackground(new Color(255, 255, 0));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// capiturando da tela
				Conta conta = new Conta();
				Conta conta_PF = new ContaPF();
				Conta conta_PJ = new ContaPJ();
				String nomeUsuario = textFieldNome.getText();
				conta.setNomeUsuario(nomeUsuario);
				
				int num_agencia = Integer.parseInt(textFieldAgencia.getText());
				int num_conta = Integer.parseInt(textFieldConta.getText());
				float valor_saldo = Float.parseFloat(textFieldSaldo.getText());

				if (rdbtnPJ.isSelected()) {
					// Criar um objeto ContaPJ
					conta = new ContaPJ();
					conta.setTipoConta("PJ");
				}

				if (rdbtnPF.isSelected()) {
					// Criar um objeto ContaPF
					conta = new ContaPF();
					conta.setTipoConta("PF");
				}
				String tipoConta = conta.getTipoConta();

				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] { String.valueOf(num_agencia), String.valueOf(num_conta), tipoConta, nomeUsuario,
						String.valueOf(valor_saldo)});

			}
		});
		btnCriar.setBounds(11, 227, 77, 23);
		frame.getContentPane().add(btnCriar);
		
		//private void atualizarTabela() {
		    //DefaultTableModel tabela = (DefaultTableModel) table.getModel();
		    //tabela.setValueAt(conta.getNomeUsuario(), 0, 3);
		    //tabela.setValueAt(String.valueOf(conta.getSaldo()), 0, 4);
		//}
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBackground(new Color(0, 255, 255));
		btnDepositar.setForeground(new Color(255, 255, 255));
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// capiturando da tela
				String nomeUsuario = textFieldNome.getText();
				conta.setNomeUsuario(nomeUsuario);
						
				float valorDeposito = Float.parseFloat(textFieldSaldo.getText());
				conta.fazerDeposito(valorDeposito);
				
			    DefaultTableModel tabela = (DefaultTableModel) table.getModel();
			    tabela.setValueAt(conta.getNomeUsuario(), 0, 3);
			    tabela.setValueAt(String.valueOf(conta.getSaldo()), 0, 4);
			}
		});
		btnDepositar.setBounds(87, 227, 91, 23);
		frame.getContentPane().add(btnDepositar);

		JButton btnSacar = new JButton("Sacar");
		btnSacar.setForeground(new Color(255, 255, 255));
		btnSacar.setBackground(new Color(255, 0, 0));
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// capiturando da tela
				String nomeUsuario = textFieldNome.getText();
				conta.setNomeUsuario(nomeUsuario);
				
		        float valorSaque = Float.parseFloat(textFieldSaldo.getText());
		        conta.fazerSaque(valorSaque);
		        
			    DefaultTableModel tabela = (DefaultTableModel) table.getModel();
			    tabela.setValueAt(conta.getNomeUsuario(), 0, 3);
			    tabela.setValueAt(String.valueOf(conta.getSaldo()), 0, 4);
			}
		});
		btnSacar.setBounds(178, 227, 80, 23);
		frame.getContentPane().add(btnSacar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 128, 0));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					DefaultTableModel tabela = (DefaultTableModel) table.getModel();
					tabela.removeRow(selectedRow);
				}else {
					JOptionPane.showMessageDialog(frame, "Selecione uma linha para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnExcluir.setBounds(260, 227, 77, 23);
		frame.getContentPane().add(btnExcluir);
		
		textFieldSaldo = new JTextField();
		textFieldSaldo.setColumns(10);
		textFieldSaldo.setBounds(52, 124, 57, 20);
		frame.getContentPane().add(textFieldSaldo);
		
		textFieldAgencia = new JTextField();
		textFieldAgencia.setColumns(10);
		textFieldAgencia.setBounds(10, 196, 57, 20);
		frame.getContentPane().add(textFieldAgencia);
		
		textFieldConta = new JTextField();
		textFieldConta.setColumns(10);
		textFieldConta.setBounds(77, 196, 57, 20);
		frame.getContentPane().add(textFieldConta);
	}
}
