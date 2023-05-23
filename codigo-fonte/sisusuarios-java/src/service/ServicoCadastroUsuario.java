package service;

import repository.RepositorioUsuario;

public class ServicoCadastroUsuario {

	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	
	public String gerarmatricula() {
		String matriculaGerada = null;
		int quantidadeUsuario = repositorioUsuario.retornaUsuarios().size();
		
		matriculaGerada = "IMP-" + (quantidadeUsuario + 1);
		
		
		return matriculaGerada;
	}
	
}
