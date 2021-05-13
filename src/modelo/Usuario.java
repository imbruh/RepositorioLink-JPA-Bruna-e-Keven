package modelo;

/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity 
@Table(name="Usuario20191370012_20191370011")
public class Usuario {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;


	@OneToMany (cascade=CascadeType.ALL, orphanRemoval = true) 
	@JoinColumn(name="usuario") 	
	private List<Visualizacao> visualizacoes = new ArrayList<>();
	
	@Version
	private int versao;


	public Usuario() {}
	public Usuario (String email){
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	
	public void remover(Visualizacao vis) {
		visualizacoes.remove(vis);
	}

	public String getIdVisualizacao() {
        String id = "";
        for (Visualizacao visu: visualizacoes) {
            id += visu != null ? visu.getId() + "," : "";
        }
        return id;
    }

	@Override
	public String toString() {
		return "Usuario [id = " + id + ", email = " + email + ", visualizações = " + getIdVisualizacao() + "]";
	}	

}
