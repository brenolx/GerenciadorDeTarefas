package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Usuario;

public class UsuarioDAO {

    private Connection conn = null;
    
    public UsuarioDAO() {
    }

    public int cadastrarUsuario(Usuario usuario) throws SQLException, IOException{
    	conn = BancoDados.conectar();
    	
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        try{
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
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
//
    public List<Usuario> buscarUsuario() throws SQLException, IOException {
    	conn = BancoDados.conectar();
    	
    	String sql = "SELECT * FROM usuario ORDER BY nome";
        List<Usuario> listaLivros = new ArrayList<>();
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        
        try {
        	while (rs.next()) {
        		 Usuario usuario = new Usuario();
        		 usuario.setId(rs.getInt("id"));
        		 usuario.setNome(rs.getString("nome"));
        		 usuario.setEmail(rs.getString("email"));
        		 usuario.setSenha(rs.getString("senha"));
        		 listaLivros.add(usuario);
            }
            return listaLivros;
        }finally {
        	BancoDados.finalizarResultSet(rs);
        	BancoDados.finalizarStatement(st);
        	BancoDados.desconectar();
        }
    }
//
//    public int atualizarLivro(Livro livro) throws SQLException {
//        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ?, paginas = ? WHERE id = ?";
//        try (PreparedStatement st = conn.prepareStatement(sql)) {
//            st.setString(1, livro.getTitulo());
//            st.setString(2, livro.getAutor());
//            st.setInt(3, livro.getAnoPublicacao());
//            st.setInt(4, livro.getPaginas());
//            st.setInt(5, livro.getId());
//            return st.executeUpdate();
//        }
//    }
//
//    public int removerLivro(int id) throws SQLException {
//        String sql = "DELETE FROM livro WHERE id = ?";
//        try (PreparedStatement st = conn.prepareStatement(sql)) {
//            st.setInt(1, id);
//            return st.executeUpdate();
//        }
//    }
}