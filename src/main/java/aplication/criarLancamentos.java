package aplication;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Lancamento;
import model.Pessoa;
import model.TipoLancamento;
import util.JpaUtil;

public class criarLancamentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manage = JpaUtil.getEntityManager();
		EntityTransaction trx = manage.getTransaction();
		
		trx.begin();
		
		Calendar dataVencimento1 = Calendar.getInstance();
		dataVencimento1.set(2017,6,9,0,0,0);
		
		Calendar dataVencimento2 = Calendar.getInstance();
		dataVencimento2.set(2017,6,7,0,0,0);
		
		Pessoa client = new Pessoa();
		client.setNome("Empresa");
		
		Pessoa fornecedor = new Pessoa();
		fornecedor.setNome("Fornecedor");
		
		Lancamento lancamento1 = new Lancamento();
		lancamento1.setDescricao("Venda de licença de software");
		lancamento1.setPessoa(client);
		lancamento1.setDataVencimento(dataVencimento1.getTime());
		lancamento1.setDataPagamento(dataVencimento1.getTime());
		lancamento1.setValor(new BigDecimal(103_000));		
		lancamento1.setTipo(TipoLancamento.RECEITA);
		
		Lancamento lancamento2 = new Lancamento();
		lancamento2.setDescricao("Venda suporte Anual");
		lancamento2.setPessoa(client);
		lancamento2.setDataVencimento(dataVencimento1.getTime());
		lancamento2.setDataPagamento(dataVencimento1.getTime());
		lancamento2.setValor(new BigDecimal(15_000));		
		lancamento2.setTipo(TipoLancamento.RECEITA);
		
		Lancamento lancamento3 = new Lancamento();
		lancamento3.setDescricao("Treinamento de Equipe");
		lancamento3.setPessoa(fornecedor);
		lancamento3.setDataVencimento(dataVencimento2.getTime());
		lancamento3.setDataPagamento(dataVencimento2.getTime());
		lancamento3.setValor(new BigDecimal(68_000));		
		lancamento3.setTipo(TipoLancamento.DESPESA);
		
		manage.persist(client);
		manage.persist(fornecedor);
		manage.persist(lancamento1);
		manage.persist(lancamento2);
		manage.persist(lancamento3);
		
		trx.commit();
		manage.close();
	}

}
