package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Tarefa;

public class TarefaDAO {
	private Connection conn = null;
	
	public TarefaDAO() {		
	}
	
	
	public int cadastrarTarefa(int idUsuario, Tarefa tarefa) throws SQLException, IOException{
    	conn = BancoDados.conectar();
    	
        String sql = "INSERT INTO tarefas (titulo, prazo, conteudo, usuario_id) VALUES (?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        try{
            st.setString(1, tarefa.getTitulo());
            st.setString(2, tarefa.getPrazo());
            st.setString(3, tarefa.getConteudo());
            st.setInt(4, idUsuario);
            
            return st.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        finally {
        	BancoDados.finalizarStatement(st);
        	BancoDados.desconectar();
        }
		return 0; // o envio pro banco falhou
    }
}
