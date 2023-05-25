package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class FabricaConexaoBancoDados {
	
	//private static String USUARIO = "root"; // Nome do usuario
	private static String USUARIO = "uzs11jxcsg3ojqdr"; // Nome do usuario
	//private static String SENHA = "root";//Senha do usuario
	private static String SENHA = "8VYoUALExdUUvN9gbwck";//Senha do usuario
	
	//private static String BANCO_URL = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	private static String BANCO_URL = "jdbc:mysql://b9z95uxaicqeqn3anzj9-mysql.services.clever-cloud.com:3306/b9z95uxaicqeqn3anzj9?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	public Connection criarConexaoDb_usuarios() {
		Connection conexao;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Indica o Drive que vai ser usado
			
			conexao = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);// Cria a conexão
			System.out.println("Deu certo a conexão!!!");
		
		} catch (Exception mensagemErro) {
			conexao = null;
			System.out.println("Problema ao conectar!!");
			JOptionPane.showMessageDialog(null, "Erro de banco");
			System.out.println("#######################");
			System.out.println(mensagemErro);// Apresenta o erro no console
			
		}
	
		
		return conexao;
	}
	
	
}
