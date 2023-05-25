package view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ControllerTelaAdministraUsuario;
import model.Usuario;
import repository.RepositorioUsuario;

public class TelaAdministraUsuario {

	public void telaAdmUsuario(Usuario usuarioLogado, JFrame frameGerenciaUsuario) {
		
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		
		List<Usuario> listaUsuarios = repositorioUsuario.retornaUsuarios();
		
		int quantidadeListas = listaUsuarios.size();
		
		String [][] tabelaString = new String [quantidadeListas][4];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for(Usuario usuarioTabela : listaUsuarios ) {
			
			tabelaString[posicaoLinha][posicaoColuna] = usuarioTabela.getMatricula();
			
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna] = usuarioTabela.getNome();
			
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna] = usuarioTabela.getEmail();
			
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna] = usuarioTabela.getTipoUsuario();
			
			posicaoColuna = 0 ;
			
			posicaoLinha ++;
			
			
		}
		
		String nomeColunas [] = {"MATRICULA", "NOME", "EMAIL", "TIPO"};
		
		JTable tabelaUsuario = new JTable(tabelaString,nomeColunas );
		tabelaUsuario.setBounds(30,40,300,300);
		JPanel panelAdmUsuario = new JPanel();
		JScrollPane scrollPaneTabelaUsuario = new JScrollPane(tabelaUsuario);
		
		
		
		JFrame frameAdmUsuario = new JFrame();
		
		frameAdmUsuario.setSize(500,600);
		
		
		panelAdmUsuario.add(scrollPaneTabelaUsuario);
		
		JButton botaoDeletar = new JButton("Deletar");
		panelAdmUsuario.add(botaoDeletar);
		
		JButton botaoAlterar = new JButton("Alterar");
		panelAdmUsuario.add(botaoAlterar);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelAdmUsuario.add(botaoVoltar);
		
		JTextField textMatricula = new JTextField(10);
		panelAdmUsuario.add(textMatricula);
		
		frameAdmUsuario.add(panelAdmUsuario);
		frameAdmUsuario.setVisible(true);
		
		
		ControllerTelaAdministraUsuario controllerTelaAdministraUsuario = new ControllerTelaAdministraUsuario(textMatricula, frameGerenciaUsuario, frameAdmUsuario);
		botaoAlterar.addActionListener(controllerTelaAdministraUsuario);
		botaoDeletar.addActionListener(controllerTelaAdministraUsuario);
		botaoVoltar.addActionListener(controllerTelaAdministraUsuario);
	}
	
	
}
