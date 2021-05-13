/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Assunto;

public class DAOAssunto  extends DAO<Assunto>{
	
	public Assunto read (Object chave){
		try{
			String palavra = (String) chave;
			TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a where a.palavra = :p ", Assunto.class);
			q.setParameter("p", palavra);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public List<Assunto> readLike (String palavras){		
		TypedQuery<Assunto> q = manager.createQuery
				("select a from Assunto a where a.palavra like '%"+ palavras +"%' order by a.palavra",Assunto.class);
		return q.getResultList();
	}
	
	public List<Assunto> readAssunto(String video) {
		TypedQuery<Assunto> q = manager.createQuery(
		"select v from Assunto a where a.video like :v order by a.palavra", Assunto.class);
		q.setParameter("v", "%"+video+"%");

		return q.getResultList(); 
	}
}
