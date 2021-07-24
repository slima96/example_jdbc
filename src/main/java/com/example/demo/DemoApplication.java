package com.example.demo;

import java.util.Scanner;

import com.example.demo.dao.CursoDAO;
import com.example.demo.entities.Curso;

public class DemoApplication {

	public static void main(String[] args) {
		CursoDAO cursoDao = new CursoDAO();
		
		System.out.println("Lista com todos os cursos:");
		cursoDao.listarTodos().forEach(System.out::println);
		System.out.println("\n");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o ID do curso que deseja buscar: ");
		int id = sc.nextInt();
		
		System.out.println("\n");
		System.out.println("Curso de ID: " + id);
		Curso curso = cursoDao.buscarCurso(id);
		System.out.println(curso);
		
		sc.close();
	}

}
