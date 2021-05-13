/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Visualizacao;

public class DAOVisualizacao  extends DAO<Visualizacao>{

	public Visualizacao read (Object chave){
		try{
			int id = (Integer) chave;
			TypedQuery<Visualizacao> q = manager.createQuery("select v from Visualizacao v where v.id=:i", Visualizacao.class);
			q.setParameter("i", id);
			return q.getSingleResult();
			
		}catch(NoResultException e){
			return null;
		}
	}
}

