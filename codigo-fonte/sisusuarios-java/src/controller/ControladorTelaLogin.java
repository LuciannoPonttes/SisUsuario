package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import service.GerenciaSessao;
import view.TelaGerenciaUsuario;

public class ControladorTelaLogin implements ActionListener {

	JTextField textMatriculaRecebido;	
	JTextField textSenhaRecebido;	
	JFrame frameTelaLoginRecebido;
	
	
	public ControladorTelaLogin(JTextField textMatriculaRecebido, 
			JTextField textSenhaRecebido, JFrame frameTelaLogin) {
		this.textMatriculaRecebido = textMatriculaRecebido;
		this.textSenhaRecebido = textSenhaRecebido;
		this.frameTelaLoginRecebido = frameTelaLogin;
	}
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	GerenciaSessao gerenciaSessao = new GerenciaSessao();
	
	TelaGerenciaUsuario telaGerenciaUsuario = new TelaGerenciaUsuario();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Usuario usuarioEncontrado = gerenciaSessao.validaUsuario(textMatriculaRecebido.getText(), textSenhaRecebido.getText());
		
		if(usuarioEncontrado != null) {
			JOptionPane.showMessageDialog(null, "Bem vindo(a) " + usuarioEncontrado.getNome());
			System.out.println("Iniciar o sistema");
			frameTelaLoginRecebido.setVisible(false);
			telaGerenciaUsuario.telaGerenciarUsuario(usuarioEncontrado, frameTelaLoginRecebido);
			textSenhaRecebido.setText(null);
			textMatriculaRecebido.setText(null);
		
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos!! ");
		
		}
		
	}

}
