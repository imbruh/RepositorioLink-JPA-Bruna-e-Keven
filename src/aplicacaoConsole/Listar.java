package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Usuario;
import modelo.Assunto;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {
	
	public Listar(){
		try {
			Fachada.inicializar();

			System.out.println("Listagem de assuntos:");
			for(Assunto a : Fachada.listarAssunto())	
				System.out.println(a);
			
			System.out.println("\nListagem de visualizações:");
			for(Visualizacao v : Fachada.listarVisualizacao())	
				System.out.println(v);
			
			System.out.println("\nListagem de videos:");
		    for(Video v : Fachada.listarVideo())	
				System.out.println(v);
			
			System.out.println("\nListagem de usuarios:");
			for(Usuario u : Fachada.listarUsuario() )		
				System.out.println(u);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

