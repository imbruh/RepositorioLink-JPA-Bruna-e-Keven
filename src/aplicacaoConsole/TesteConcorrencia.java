package aplicacaoConsole;
import java.util.Scanner;
import fachada.Fachada;


public class TesteConcorrencia {

	private Scanner teclado = new Scanner(System.in);
	
	public TesteConcorrencia() {

		try {
			Fachada.inicializar();
			
			System.out.print("Email atual: ");
			String emailAtual = teclado.nextLine();
	
			System.out.print("Novo email:");
			String novoEmail = teclado.nextLine();
			Fachada.atualizarUsuario(emailAtual, novoEmail);
	
			System.out.println("email atualizado com sucesso: \n ");	
		}
		catch(Exception e) {
			System.out.println("=>"+e);
		}

		finally {
			Fachada.finalizar();
		}
	}
	
	
	
	public static void main(String[] args) {
		new TesteConcorrencia();
	}

}