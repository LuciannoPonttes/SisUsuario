package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControladorTelaAlterarUsuario;
import model.Usuario;

public class TelaAlterarUsuario {

	public void telaAlterarUsuario(Usuario usuario, JFrame frameGerenciarUsuario) {
		
		
		String nome = "  NOME:";
		String email = "  EMAIL:";
		String tipoUsuario = " TIPO DE USUARIO -  1 ADM / 2 - COMUM: ( PERFIL ATUAL " + usuario.getTipoUsuario() +" )";
		
		JFrame frameAlterarUsuario = new JFrame();
		frameAlterarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlterarUsuario.setSize(450, 300);
		
		JPanel panelAlterarUsuario = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelAlterarUsuario.setLayout(grid);
		
		
		JLabel labelMatricula = new JLabel("MATRICULA");
		panelAlterarUsuario.add(labelMatricula);
		
		JTextField textMatricula = new JTextField();
		textMatricula.setEditable(false);
		textMatricula.setText(usuario.getMatricula());
		panelAlterarUsuario.add(textMatricula);
		
		JLabel labelNome = new JLabel(nome);
		panelAlterarUsuario.add(labelNome);
		
		JTextField textNome = new JTextField();
		textNome.setText(usuario.getNome());
		panelAlterarUsuario.add(textNome);
		
		JLabel labelEmail = new JLabel(email);
		panelAlterarUsuario.add(labelEmail);
		
		JTextField textEmail = new JTextField();
		textEmail.setText(usuario.getEmail());
		panelAlterarUsuario.add(textEmail);
		
		JLabel labelTipoUsuaio = new JLabel(tipoUsuario);
		panelAlterarUsuario.add(labelTipoUsuaio);
		
		JTextField textTipoUsuario = new JTextField();
		panelAlterarUsuario.add(textTipoUsuario);
		
		JLabel labelSenha = new JLabel("SENHA");
		panelAlterarUsuario.add(labelSenha);
		
		JPasswordField passSenha = new JPasswordField();
		passSenha.setText(usuario.getSenha());
		panelAlterarUsuario.add(passSenha );
		
		
		JButton botaoEnviar = new JButton("Alterar");
		panelAlterarUsuario.add(botaoEnviar);
		
		JButton botaoSair = new JButton("Voltar");
		panelAlterarUsuario.add(botaoSair);
		
		frameAlterarUsuario.add(panelAlterarUsuario);
		frameAlterarUsuario.setVisible(true);
		
		
		
		ControladorTelaAlterarUsuario controladorTelaAlterarUsuario = new ControladorTelaAlterarUsuario(textMatricula, textNome, textEmail, textTipoUsuario, frameAlterarUsuario, frameGerenciarUsuario,passSenha);
		botaoEnviar.addActionListener(controladorTelaAlterarUsuario);
		botaoSair.addActionListener(controladorTelaAlterarUsuario);
		
	}
	
}
