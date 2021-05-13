/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Video;

public class DAOVideo  extends DAO<Video>{

	public Video read (Object chave) {
		try{
			String nome = (String) chave;	
			TypedQuery<Video> q = manager.createQuery("select v from Video v where v.nome=:n", Video.class);
			q.setParameter("n", nome);
			return q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}

	//consulta
	public List<Video> readAssunto(String assunto) {
		TypedQuery<Video> q = manager.createQuery(
		"select v from Video v JOIN v.assuntos a where a.palavra like :a order by v.nome", Video.class);
		q.setParameter("a", "%"+assunto+"%");

		return q.getResultList();
	}
	
	public List<Video> readUsuario(String email) {
		TypedQuery<Video> q = manager.createQuery(
		"select v from Video v JOIN v.visualizacoes vi JOIN vi.usuario u where u.email like :e order by v.nome", Video.class);
		q.setParameter("e", "%"+email+"%");

		return q.getResultList();
	}

}

