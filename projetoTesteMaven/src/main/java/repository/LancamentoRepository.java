package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Lancamento;

public class LancamentoRepository {
	private EntityManager manager;
	
	public LancamentoRepository (EntityManager manager){
		this.manager = manager;
	}
	
	public List<Lancamento> todos(){
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento",Lancamento.class);
		return query.getResultList();
	}
	public void adicionar(Lancamento lancamento){
		this.manager.persist(lancamento);
	}
}
