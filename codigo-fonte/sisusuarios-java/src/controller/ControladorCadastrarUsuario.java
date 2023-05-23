package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import service.ServicoCadastroUsuario;

public class ControladorCadastrarUsuario implements ActionListener {

	JTextField textNomeRecebido;
	JTextField textEmailRecebido;
	JTextField textTipoUsuarioRecebido;
	
	JFrame frameMenuUsuarioRecebido;
	JFrame frameCadastrarUsuarioRecebido;
	
	
	
	public ControladorCadastrarUsuario(JTextField textNomeRecebido, JTextField textEmailRecebido,
			JTextField textTipoUsuarioRecebido, JFrame frameMenuUsuarioRecebido, JFrame frameCadastrarUsuarioRecebido) {
		this.textNomeRecebido = textNomeRecebido;
		this.textEmailRecebido = textEmailRecebido;
		this.textTipoUsuarioRecebido = textTipoUsuarioRecebido;
		this.frameMenuUsuarioRecebido = frameMenuUsuarioRecebido;
		this.frameCadastrarUsuarioRecebido = frameCadastrarUsuarioRecebido;
	}
	
	ServicoCadastroUsuario servicoCadastroUsuario = new ServicoCadastroUsuario();
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

	@Override
	public void actionPerformed(ActionEvent botaoPressionado) {
		
		if (botaoPressionado.getActionCommand().equals("Voltar")) {
			frameMenuUsuarioRecebido.setVisible(true);
			frameCadastrarUsuarioRecebido.setVisible(false);
		}
		
		if (botaoPressionado.getActionCommand().equals("Enviar")) {
			System.out.println("Cadastrar!!");
			
			boolean salvar = repositorioUsuario.salvarUsuario(popularUsuario());
			if(salvar) {
				frameMenuUsuarioRecebido.setVisible(true);
				frameCadastrarUsuarioRecebido.setVisible(false);
				JOptionPane.showMessageDialog(null, "Usuario registrado com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Erro!! Usuario Não registrado!!");
			}
		}
		
	}
	
	public Usuario popularUsuario() {
		Usuario usuarioCadastrado  = new Usuario();
		String matricula = servicoCadastroUsuario.gerarmatricula();
		
		if(textTipoUsuarioRecebido.getText().equals("1") || textTipoUsuarioRecebido.getText().equals("2") ) {
			if(textTipoUsuarioRecebido.getText().equals("1")) {
				usuarioCadastrado.setTipoUsuario("ADM");
			}
			
			if(textTipoUsuarioRecebido.getText().equals("2")) {
				usuarioCadastrado.setTipoUsuario("COMUM");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Tipo de Usuario Invalido");
		}
		
		usuarioCadastrado.setNome(textNomeRecebido.getText());
		usuarioCadastrado.setEmail(textEmailRecebido.getText());
		usuarioCadastrado.setMatricula(matricula);
		usuarioCadastrado.setSenha("Senha");
		
		return usuarioCadastrado ;
	}
	
	
	
}
