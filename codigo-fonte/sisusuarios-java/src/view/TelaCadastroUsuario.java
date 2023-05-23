package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControladorCadastrarUsuario;
import model.Usuario;

public class TelaCadastroUsuario {

	public void cadastrarUsuario(Usuario usuarioLogado, JFrame frameMenuUsuario) {
		
		String nome = "  NOME:";
		String email = "  EMAIL:";
		String tipoUsuario = " TIPO DE USUARIO -  1 ADM / 2 - COMUM:";
		
		JFrame frameCadastrarUsuario = new JFrame();
		frameCadastrarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastrarUsuario.setSize(400, 250);
		
		JPanel panelCadastrarUsuario = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelCadastrarUsuario.setLayout(grid);
		
		JLabel labelNome = new JLabel(nome);
		panelCadastrarUsuario.add(labelNome);
		
		JTextField textNome = new JTextField();
		panelCadastrarUsuario.add(textNome);
		
		JLabel labelEmail = new JLabel(email);
		panelCadastrarUsuario.add(labelEmail);
		
		JTextField textEmail = new JTextField();
		panelCadastrarUsuario.add(textEmail);
		
		JLabel labelTipoUsuaio = new JLabel(tipoUsuario);
		panelCadastrarUsuario.add(labelTipoUsuaio);
		
		JTextField textTipoUsuario = new JTextField();
		panelCadastrarUsuario.add(textTipoUsuario);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelCadastrarUsuario.add(botaoEnviar);
		
		JButton botaoSair = new JButton("Voltar");
		panelCadastrarUsuario.add(botaoSair );
		
		
		
		frameCadastrarUsuario.add(panelCadastrarUsuario);
		frameCadastrarUsuario.setVisible(true);
		
		ControladorCadastrarUsuario controladorCadastrarUsuario = new ControladorCadastrarUsuario(textNome, textEmail, textTipoUsuario, frameMenuUsuario, frameCadastrarUsuario);
		botaoEnviar.addActionListener(controladorCadastrarUsuario);
		botaoSair.addActionListener(controladorCadastrarUsuario);
	}
	
	
}
