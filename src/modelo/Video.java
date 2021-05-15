package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="Video20191370012_20191370011")
public class Video {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@Column(columnDefinition = "TIMESTAMP")	
	private LocalDateTime datahora = LocalDateTime.now();
	
	private String link;
	private String nome;
	private double media;
	
	@Transient
    private String idade;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}) 
	private List<Assunto> assuntos = new ArrayList<>();
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="video")
    private List<Visualizacao> visualizacoes= new ArrayList<>();
	
	@Version
	private int versao;

	public Video() {}
	public Video(String link, String nome, Assunto assunto) throws Exception{
		this.link = link;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void remover(Visualizacao vis) {
		visualizacoes.remove(vis);
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}
	public void setVisualizacoes(List<Visualizacao> visualizacoes) {
		this.visualizacoes = visualizacoes;
	}
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	@PostLoad @PostPersist @PostUpdate  
    private void calcularIdade() {
        LocalDate hoje = LocalDate.now();
        int idadeAno = datahora.getYear() - hoje.getYear();
        int idadeMes = datahora.getMonthValue() - hoje.getMonthValue();
        this.idade = idadeAno + " anos e " + idadeMes + " meses";
    }

	public LocalDateTime getDatahora() {
		return datahora;
	}


	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}
	
	public String getAssunto() {
		String assunto = "";
		for (Assunto a: assuntos) {
			assunto += a != null ? a.getPalavra() + ", " : "";
			
		}
		return assunto;
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
		return "Video [id=" + id + ", datahora=" + datahora + ", link=" + link + ", nome=" + nome + ", media=" + media
				+ ", assuntos=" + getAssunto() + " visualizacoes=" + getIdVisualizacao() + " idade= " + idade + "]";
	}
			
}
