package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;

public class Consultar {

	public Consultar() {
		System.out.println("Listando video por determinado assunto:");
		try {
			Fachada.inicializar();
			for(Video v : Fachada.consultarVideoAssunto("python"))	
				System.out.println(v.getNome());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Fachada.inicializar();
			for(Video v : Fachada.consultarVideoAssunto("java"))	
				System.out.println(v.getNome());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nListando video visualizado por determinado usuario:");
		try {
			Fachada.inicializar();
			for(Video v : Fachada.consultarVideoUsuario("joaovictor@gmail.com"))	
				System.out.println(v.getNome());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Fachada.inicializar();
			for(Video v : Fachada.consultarVideoUsuario("luiza20@gmail.com"))	
				System.out.println(v.getNome());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nListando usuarios por determinado video:");
		try {
			Fachada.inicializar();
			for(Usuario u : Fachada.consultarUsuarioVideo("Melhor linguagem"))	
				System.out.println(u.getEmail());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
	}
	
	public static void main(String[] args) {
		new Consultar();
	}
}
