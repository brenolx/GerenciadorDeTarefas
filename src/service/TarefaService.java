package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.TarefaDAO;
import entities.Tarefa;

public class TarefaService {

	public TarefaService() {
	}
	
	
	public void cadastrarTarefa(int idUsuario, Tarefa newTarefa) throws SQLException, IOException {
		
		
		
		TarefaDAO tarefaDao = new TarefaDAO();
		
		int sucesso = tarefaDao.cadastrarTarefa(idUsuario, newTarefa);
		
		if(sucesso != 0) {
			JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Tarefa!");
		}
		
	}
}
