package repository;

import java.util.List;

import model.Usuario;

public interface InterfaceUsuario {

	public boolean salvarUsuario(Usuario usuario);
	
	public List<Usuario> retornaUsuarios();
	
	public Usuario buscarUsuario(String matricula);
	
}
