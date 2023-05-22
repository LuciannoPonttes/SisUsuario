package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import service.GerenciaSessao;

public class ControladorTelaLogin implements ActionListener {

	JTextField textMatriculaRecebido;	
	JTextField textSenhaRecebido;	
	
	
	public ControladorTelaLogin(JTextField textMatriculaRecebido, JTextField textSenhaRecebido) {
		this.textMatriculaRecebido = textMatriculaRecebido;
		this.textSenhaRecebido = textSenhaRecebido;
	}
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	GerenciaSessao gerenciaSessao = new GerenciaSessao();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Usuario usuarioEncontrado = gerenciaSessao.validaUsuario(textMatriculaRecebido.getText(), textSenhaRecebido.getText());
		
		if(usuarioEncontrado != null) {
			System.out.println("Inicia o sistema");
		
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos!! ");
		
		}
		
	}

}
