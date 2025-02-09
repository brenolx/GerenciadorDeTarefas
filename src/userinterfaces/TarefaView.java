package userinterfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.Tarefa;
import entities.Usuario;
import service.TarefaService;

public class TarefaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldTarefaPrazo;

	/**
	 * Create the frame.
	 */
	
	public TarefaView() {
		getContentPane().setLayout(null);
	}
	
	public TarefaView(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Tarefa de " + usuario.getNome().toUpperCase());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 39, 434, 14);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemSalvar = new JMenuItem("Salvar");
		mntmNewMenuItemSalvar.setFont(new Font("Dialog", Font.BOLD, 11));
		mnNewMenu.add(mntmNewMenuItemSalvar);
		
		JMenuItem mntmNewMenuItemCancelar = new JMenuItem("Cancelar");
		mntmNewMenuItemCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		mnNewMenu.add(mntmNewMenuItemCancelar);
		
		JLabel lblNewLabelTitulo = new JLabel("Titulo");
		lblNewLabelTitulo.setBounds(42, 75, 55, 16);
		contentPane.add(lblNewLabelTitulo);
		
		JLabel lblPrazoTarefa_1 = new JLabel("Prazo/Tarefa");
		lblPrazoTarefa_1.setBounds(42, 107, 77, 16);
		contentPane.add(lblPrazoTarefa_1);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(87, 76, 127, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		textFieldTarefaPrazo = new JTextField();
		textFieldTarefaPrazo.setColumns(10);
		textFieldTarefaPrazo.setBounds(164, 105, 50, 20);
		contentPane.add(textFieldTarefaPrazo);
		
		JLabel lblPrazoTarefa_2 = new JLabel("(Dias)");
		lblPrazoTarefa_2.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblPrazoTarefa_2.setBounds(118, 107, 45, 16);
		contentPane.add(lblPrazoTarefa_2);
		
		JEditorPane conteudoTexto = new JEditorPane();
		conteudoTexto.setBounds(42, 136, 352, 99);
		contentPane.add(conteudoTexto);
		
		mntmNewMenuItemCancelar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}
		});
		
		mntmNewMenuItemSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa newTarefa = new Tarefa(textFieldTitulo.getText(), textFieldTarefaPrazo.getText(), conteudoTexto.getText());
				TarefaService  tarefaService = new TarefaService();
				
				try {
					tarefaService.cadastrarTarefa(usuario.getId(), newTarefa);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
	}
}
