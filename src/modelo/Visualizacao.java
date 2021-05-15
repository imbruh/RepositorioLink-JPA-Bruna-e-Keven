package modelo;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="Visualizacao20191370012_20191370011")
public class Visualizacao {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(columnDefinition = "TIMESTAMP")	
	private LocalDate data = LocalDate.now();  	
	
	private int nota;
	
	@ManyToOne		
	private Usuario usuario;
	
	@ManyToOne
	private Video video;
	
	@Version
	private int versao;


	public Visualizacao() {}
	public Visualizacao(int nota, Usuario usuario, Video video) {
		this.nota = nota;
		this.usuario = usuario;
        this.video = video;
        
	}
	public int getNota() {
        return nota;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
		
	@Override
    public String toString() {
        return "Visualizacao [id=" + id + 
                ", nota=" + nota +
                ", usuario=" + usuario.getEmail() + ", data= "+data+", video=" + video.getNome() + "]";
    }
	
}
