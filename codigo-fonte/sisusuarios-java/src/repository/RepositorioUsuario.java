package repository;

import java.util.Iterator;
import java.util.List;

import model.Usuario;
import persistence.DaoUsuario;

public class RepositorioUsuario implements InterfaceUsuario {

	DaoUsuario daoUsuario = new DaoUsuario();
	
	@Override
	public boolean salvarUsuario(Usuario usuario) {
	
		return daoUsuario.persistirUsuario(usuario);
	}

	@Override
	public List<Usuario> retornaUsuarios() {
		// TODO Auto-generated method stub
		return daoUsuario.retornaListaUsuarioDao();
	}

	@Override
	public Usuario buscarUsuario(String matricula) {
		
		for (Usuario usuarioBusca:retornaUsuarios() ) {
			if(matricula.equals(usuarioBusca.getMatricula())) {
				return usuarioBusca;
			}	
		}
		return null;
	}

	
	
	
	
	
	

	
	
	
}
