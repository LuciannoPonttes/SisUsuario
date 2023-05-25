package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Result;

import connectionFactory.FabricaConexaoBancoDados;
import model.Usuario;

public class DaoUsuario {

	
	public Boolean persistirUsuario(Usuario usuario) {
		
		FabricaConexaoBancoDados fabricaConexaoBancoDados = new FabricaConexaoBancoDados();
		
		String sqlComando = "insert into tb_usuario (matricula, nome, email, tipo_usuario,senha) values (?, ?, ?, ?,?)";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		try {
			conexaoRecebida = fabricaConexaoBancoDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sqlComando);
			
			declaracaoComando.setString(1, usuario.getMatricula());
			declaracaoComando.setString(2, usuario.getNome());
			declaracaoComando.setString(3, usuario.getEmail());
			declaracaoComando.setString(4, usuario.getTipoUsuario());
			declaracaoComando.setString(5, usuario.getSenha());
			
			declaracaoComando.execute();
			
			System.out.println("Usuario Registrado!!");
			
		}catch (Exception erro) {
			System.err.println(erro);
			System.out.println("Erro ao registrar");
			JOptionPane.showInternalMessageDialog(null, "Verifque o banco de dados!!");
			return false;
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e) {
				System.out.println("Erro ao fechar Conexao!!");
			}
		}
		
		return true;
	}
	
	public List<Usuario> retornaListaUsuarioDao(){
		FabricaConexaoBancoDados fabricaConexaoBancoDados = new FabricaConexaoBancoDados();
		String comandoSqlBuscar = "SELECT * FROM TB_USUARIO";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		ResultSet resultadoTabela = null;
		
		List<Usuario> listaUsuario = new ArrayList<>();
		
		try {
			conexaoRecebida = fabricaConexaoBancoDados.criarConexaoDb_usuarios();
			declaracaoComando = (PreparedStatement)conexaoRecebida.prepareStatement(comandoSqlBuscar);
			
			resultadoTabela = declaracaoComando.executeQuery();
			
			
			while (resultadoTabela.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setMatricula(resultadoTabela.getString("matricula"));
				usuario.setNome(resultadoTabela.getString("nome"));
				usuario.setEmail(resultadoTabela.getString("email"));
				usuario.setTipoUsuario(resultadoTabela.getString("tipo_usuario"));
				usuario.setSenha(resultadoTabela.getString("senha"));
				listaUsuario.add(usuario);
			}
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaUsuario;
	}
	
	public boolean deletarUsuario(Usuario usuario) {
		FabricaConexaoBancoDados fabricaConexaoBancoDados = new FabricaConexaoBancoDados();
		
		String sqlComando = "delete from tb_usuario where matricula = ?";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		boolean resposta = false;
		
		try {
			conexaoRecebida = fabricaConexaoBancoDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement)conexaoRecebida.prepareStatement(sqlComando);
			declaracaoComando.setString(1, usuario.getMatricula());
			
			declaracaoComando.execute();
			resposta = true;
			
			
		}catch (Exception erro) {
			System.err.println(erro);
			System.out.println("Erro ao Deletar");
			JOptionPane.showInternalMessageDialog(null, "Verifque o banco de dados!!");
			resposta = false;
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e) {
				System.out.println("Erro ao fechar Conexao!!");
			}
		}
		
		return resposta;
		
		
	}
	
	public boolean alterarUsuario(Usuario usuario) {
		boolean reposta = false;
		
		
		FabricaConexaoBancoDados fabricaConexaoBancoDados = new FabricaConexaoBancoDados();
		
		String sqlComando = "update tb_usuario set matricula = ?, nome = ?, email = ? , tipo_usuario = ?, senha = ? where matricula = ?";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		try {
			conexaoRecebida = fabricaConexaoBancoDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sqlComando);
			
			declaracaoComando.setString(1, usuario.getMatricula());
			declaracaoComando.setString(2, usuario.getNome());
			declaracaoComando.setString(3, usuario.getEmail());
			declaracaoComando.setString(4, usuario.getTipoUsuario());
			declaracaoComando.setString(5, usuario.getSenha());
			declaracaoComando.setString(6, usuario.getMatricula());
			
			declaracaoComando.execute();
			
			System.out.println("Usuario Registrado!!");
			 reposta = true;
		}catch (Exception erro) {
			System.err.println(erro);
			System.out.println("Erro ao registrar");
			JOptionPane.showInternalMessageDialog(null, "Verifque o banco de dados!!");
			
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e) {
				System.out.println("Erro ao fechar Conexao!!");
			}
		}
		
		
		
		return reposta;
	}
	
	
	
	
	
}
