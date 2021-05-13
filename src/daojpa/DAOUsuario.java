/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario>{
	
	
	public Usuario read (Object chave){
		try{
			String email = (String) chave;
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.email=:e", Usuario.class);
			q.setParameter("e", email);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Usuario> readAll(){
		TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u order by u.id", Usuario.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	
	public List<Usuario> readVideo(String nomeVideo) {
        TypedQuery<Usuario> q = manager.createQuery(
        "select u from Usuario u JOIN u.visualizacoes vi JOIN vi.video v where v.nome=:nv", Usuario.class);
        q.setParameter("nv", nomeVideo);

        return q.getResultList();
    }

}

