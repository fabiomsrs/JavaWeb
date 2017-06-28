package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Pessoa;

public class PessoaRepository {
	private EntityManager manager;
	
	public PessoaRepository(EntityManager manager){
		this.manager = manager;		
	}
	public Pessoa porId(Long id){
		return manager.find(Pessoa.class,id);
	}
	public List<Pessoa> todas(){
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa",Pessoa.class);
		return query.getResultList();
	}
}
