package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Curso;
import com.example.demo.utils.ConnectionFactory;

public class CursoDAO {

	public List<Curso> listarTodos(){
		List<Curso> cursos = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM curso";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int duracaoHoras = rs.getInt("duracao_horas");
				
				cursos.add(new Curso(id, nome, duracaoHoras));
				
			}
			
		} catch (SQLException e) {
			System.out.println("listagem de cursos falhou");
			e.printStackTrace();
		}
		
		
		return cursos;
	}

	public Curso buscarCurso(int id) {
		Curso curso = new Curso();
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM curso WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setDuracaoHoras(rs.getInt("duracao_horas"));		
			}
			
		} catch (SQLException e) {
			System.out.println("listagem de cursos falhou");
			e.printStackTrace();
		}
		
		return curso;
	}
}
