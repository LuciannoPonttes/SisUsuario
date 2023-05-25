package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import persistence.DaoUsuario;
import repository.RepositorioUsuario;
import view.TelaAlterarUsuario;

public class ControllerTelaAdministraUsuario implements ActionListener {

	JTextField textMatriculaRecebida;
	JFrame frameMenuUsuario;
	JFrame frametelaAdmUsuario;
	
	
	public ControllerTelaAdministraUsuario(JTextField textMatriculaRecebida, JFrame frameMenuUsuario,
			JFrame frametelaAdmUsuario) {
		
		this.textMatriculaRecebida = textMatriculaRecebida;
		this.frameMenuUsuario = frameMenuUsuario;
		this.frametelaAdmUsuario = frametelaAdmUsuario;
	}

	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	TelaAlterarUsuario telaAlterarUsuario = new TelaAlterarUsuario();


	@Override
	public void actionPerformed(ActionEvent botaoPressionado) {
		
		String botao = botaoPressionado.getActionCommand();
		
		switch (botao) {
		
		case "Deletar":
			System.out.println("Deletar a "+ textMatriculaRecebida.getText());
			
			if (deletarUsuario(validaExistenciaUsuario())) {
				frameMenuUsuario.setVisible(true);
				frametelaAdmUsuario.setVisible(false);
			}
			
			break;
		case "Alterar":
			
			System.out.println("Alterar a "+ textMatriculaRecebida.getText());
			
			if(validaExistenciaUsuario() != null) {
				//Abrir tela de alterar
				frametelaAdmUsuario.setVisible(false);
				telaAlterarUsuario.telaAlterarUsuario(validaExistenciaUsuario(),frametelaAdmUsuario);
			}
			
			break;
		case "Voltar":
			frameMenuUsuario.setVisible(true);
			frametelaAdmUsuario.setVisible(false);
		}

	}
	
	
	
	public boolean deletarUsuario(Usuario usuario) {
		boolean reposta = false;
		
		if(usuario != null) {	
			reposta = repositorioUsuario.deletarUsuario(usuario);
			if (reposta) {
				JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao deletar Verifique com o ADM");
				
			}
		}
		return reposta;
	}
	
	
	public Usuario validaExistenciaUsuario() {
		Usuario usuarioRecebido = repositorioUsuario.buscarUsuario(textMatriculaRecebida.getText());
		
		if (usuarioRecebido == null) {
			JOptionPane.showMessageDialog(null, "Matricula não encontrada");
			return null;
		}
		
		return usuarioRecebido;
	}
	
	
	
}
