package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import service.GerarPdf;
import view.TelaAdministraUsuario;
import view.TelaCadastroUsuario;

public class ControladorTelaGerenciaUsuario implements ActionListener {
	
	Usuario usuarioRecebido;
	JFrame frameTelaLoginRecebido;
	JTextField textRespostaRecebido;
	JFrame frameTelaGerenciaUsuarioRecebido;
	
	public ControladorTelaGerenciaUsuario(Usuario usuario, JFrame frameTelaLogin, 
			JTextField textResposta, JFrame frameTelaGerenciaUsuario) {
		this.usuarioRecebido = usuario;
		this.frameTelaLoginRecebido = frameTelaLogin;
		this.textRespostaRecebido = textResposta;
		this.frameTelaGerenciaUsuarioRecebido =  frameTelaGerenciaUsuario;
	}
	
	TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
	
	TelaAdministraUsuario telaAdministraUsuario = new TelaAdministraUsuario();
	
	GerarPdf gerarPdf = new GerarPdf();

	@Override
	public void actionPerformed(ActionEvent botaoPressionado) {
		
		if(botaoPressionado.getActionCommand().equals("Enviar")) {
			if(textRespostaRecebido.getText().equals("1") ||
					textRespostaRecebido.getText().equals("2") || textRespostaRecebido.getText().equals("3") ) { 
				if(textRespostaRecebido.getText().equals("1")) {
					System.out.println("botao enviar apertado");
					cadastroUsuario.cadastrarUsuario(usuarioRecebido, frameTelaGerenciaUsuarioRecebido);
					frameTelaGerenciaUsuarioRecebido.setVisible(false);
				}
				if(textRespostaRecebido.getText().equals("2")) {
					System.out.println("Gerenciar Usuario");
					telaAdministraUsuario.telaAdmUsuario(usuarioRecebido, frameTelaGerenciaUsuarioRecebido);
					frameTelaGerenciaUsuarioRecebido.setVisible(false);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
			}
		}
		
		if(botaoPressionado.getActionCommand().equals("Sair")) {
			System.out.println("botão sair apertado");
			frameTelaLoginRecebido.setVisible(true);
			frameTelaGerenciaUsuarioRecebido.setVisible(false);
		}
		
		
		
		
	}
	
	
	
	
}
