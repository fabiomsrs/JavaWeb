package domain;

import java.util.Date;

import exception.NegocioException;
import model.Lancamento;
import repository.LancamentoRepository;

public class CadastroLancamento {
	private LancamentoRepository lancamentos;
	
	public CadastroLancamento(LancamentoRepository lancamentos){
		this.lancamentos = lancamentos;		
	}
	
	public void salvar(Lancamento lancamento) throws NegocioException{
		if(lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())){
			throw new NegocioException("Data de pagamento nao pode ser uma data futura");
		}
		this.lancamentos.adicionar(lancamento);
	}
}
