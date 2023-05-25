package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;

public class ControladorTelaAlterarUsuario implements ActionListener {
	
	JTextField textMatriculaRecebido;
	JTextField textNomeRecebido;
	JTextField textEmailRecebido;
	JTextField textTipoUsuarioRecebido;
	
	JFrame frameTelaAlterar;
	JFrame frameTelaAdministrar;
	JPasswordField passSenhaRecebida;
	
	
	public ControladorTelaAlterarUsuario(JTextField textMatriculaRecebido, JTextField textNomeRecebido,
			JTextField textEmailRecebido, JTextField textTipoUsuarioRecebido, JFrame frameTelaAlterar,
			JFrame frameTelaAdministrar, JPasswordField passSenha) {
		this.textMatriculaRecebido = textMatriculaRecebido;
		this.textNomeRecebido = textNomeRecebido;
		this.textEmailRecebido = textEmailRecebido;
		this.textTipoUsuarioRecebido = textTipoUsuarioRecebido;
		this.frameTelaAlterar = frameTelaAlterar;
		this.frameTelaAdministrar = frameTelaAdministrar;
		this.passSenhaRecebida = passSenha;
	}
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();


	@Override
	public void actionPerformed(ActionEvent botaoPressionado) {
		String botao =  botaoPressionado.getActionCommand();
		
		if(botao.equals("Alterar")) {
			System.out.println("Alterar");
			
			if(alterarUsuario()) {
				JOptionPane.showMessageDialog(null, "O usuario foi alterardo!!");
				frameTelaAlterar.setVisible(false);
				frameTelaAdministrar.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "Erro na alteração");
			}
		}
		
		if(botao.equals("Voltar")) {
			frameTelaAlterar.setVisible(false);
			frameTelaAdministrar.setVisible(true);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public boolean alterarUsuario() {
		boolean resposta = false;
		
		Usuario usuarioAlteracao = new Usuario();
		
		
		if(textTipoUsuarioRecebido.getText().equals("1") || textTipoUsuarioRecebido.getText().equals("2") ) {
			if(textTipoUsuarioRecebido.getText().equals("1")) {
				usuarioAlteracao.setTipoUsuario("ADM");
			}
			
			if(textTipoUsuarioRecebido.getText().equals("2")) {
				usuarioAlteracao.setTipoUsuario("COMUM");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Tipo de Usuario Invalido");
		}
		
		
		usuarioAlteracao.setMatricula(textMatriculaRecebido.getText());
		usuarioAlteracao.setNome(textNomeRecebido.getText());
		usuarioAlteracao.setEmail(textEmailRecebido.getText());
		usuarioAlteracao.setSenha(passSenhaRecebida.getText());
		
		resposta = repositorioUsuario.alterarUsuario(usuarioAlteracao);
		
		return resposta;
	}

}
