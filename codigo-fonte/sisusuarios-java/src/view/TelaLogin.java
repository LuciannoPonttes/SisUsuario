package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin {

	
	public void iniciarTelaLogin() {
		
		String nome = "  USUARIO:";
		String senha = "  SENHA";
		
		
		//Criação do frame
		JFrame frameTelaLogin = new JFrame();
		frameTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTelaLogin.setSize(300,300);
		frameTelaLogin.setTitle("Tela Login");
		
		// Criação do painel
		JPanel panelTelaLogin = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelTelaLogin.setLayout(grid);
		
		JLabel labelNome = new JLabel(nome);
		panelTelaLogin.add(labelNome);
		
		JTextField textUsuario = new JTextField(10);
		panelTelaLogin.add(textUsuario);
		
		JLabel labelSenha = new JLabel(senha);
		panelTelaLogin.add(labelSenha);
		
		JTextField textSenha = new JTextField(10);
		panelTelaLogin.add(textSenha);
		
		JButton buttonLogin = new JButton("Login");
		panelTelaLogin.add(buttonLogin);
		
		frameTelaLogin.add(panelTelaLogin);
		frameTelaLogin.setVisible(true);
		
		
	}
	
	
}
