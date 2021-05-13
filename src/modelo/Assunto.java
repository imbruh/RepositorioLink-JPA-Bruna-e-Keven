package modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity 		
@Table(name="Assunto20191370012_20191370011")
public class Assunto {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String palavra;	
	
	@ManyToMany(cascade={CascadeType.ALL,CascadeType.MERGE,CascadeType.REMOVE})
	List<Video> videos = new ArrayList<>();		
	
	@Version
	private int versao;
	
	public Assunto (){}
	public Assunto(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	public String getNomeVideos() {
		String video = "";
		for (Video a: videos) {
			video += a != null ? a.getNome() + ", " : "";
			
		}
		return video;
	}
	
	@Override
	public String toString() {
		String texto = "Assunto [palavra=" + palavra;
		texto+=", videos=";
		for(Video v : videos) {
			texto += v.getNome() + ", ";
		}
		texto+="]\n";
		return texto;
	}	

		
}
