package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControladorTelaGerenciaUsuario;
import controller.ControladorTelaLogin;
import model.Usuario;

public class TelaGerenciaUsuario {

	public void telaGerenciarUsuario(Usuario usuarioLogado, JFrame frameTelaLogin){
		
		String opcao1 = "Digite 1 - Cadastrar";
		String opcao2 = "Digite 2 - Gerenciar";
		
		
		JFrame frameGerenciaUsuario = new JFrame();
		frameGerenciaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGerenciaUsuario.setSize(400, 250);
		
		JPanel panelGerenciaUsuario = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelGerenciaUsuario.setLayout(grid);
		
		JLabel labelOpcao1 = new JLabel(opcao1);
		panelGerenciaUsuario.add(labelOpcao1);
		
		JLabel labelOpcao2 = new JLabel(opcao2);
		panelGerenciaUsuario.add(labelOpcao2);
		
		
		
		JTextField textResposta = new JTextField();
		panelGerenciaUsuario.add(textResposta);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelGerenciaUsuario.add(botaoEnviar);
		
		JButton botaoSair = new JButton("Sair");
		panelGerenciaUsuario.add(botaoSair );
		
		frameGerenciaUsuario.add(panelGerenciaUsuario);
		frameGerenciaUsuario.setVisible(true);
		
		ControladorTelaGerenciaUsuario controladorTelaGerenciaUsuario = new ControladorTelaGerenciaUsuario(usuarioLogado, frameTelaLogin, textResposta,frameGerenciaUsuario);
		botaoEnviar.addActionListener(controladorTelaGerenciaUsuario);
		botaoSair.addActionListener(controladorTelaGerenciaUsuario);
		
	}
	
	
}
