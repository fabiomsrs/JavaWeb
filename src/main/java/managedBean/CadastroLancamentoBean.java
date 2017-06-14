package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.CadastroLancamento;
import exception.NegocioException;
import model.Lancamento;
import model.Pessoa;
import model.TipoLancamento;
import repository.LancamentoRepository;
import repository.PessoaRepository;
import util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;
	
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}	
	
	public List<Pessoa> getTodasPessoas() {		
		return todasPessoas;
	}
	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}
	public TipoLancamento[] getTiposLancamentos(){		
		return TipoLancamento.values();
	}
	
	public void prepararCadastro(){
		EntityManager manager = JpaUtil.getEntityManager();
		try{
			PessoaRepository pessoas = new PessoaRepository(manager);
			this.todasPessoas = pessoas.todas();
		}finally{
			manager.close();
		}		
	}
	public void salvar(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{			
			trx.begin();
			CadastroLancamento cadastro = new CadastroLancamento(new LancamentoRepository(manager));
			cadastro.salvar(lancamento);
			
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lancamento salvo com sucesso"));
		}catch(NegocioException e){
			trx.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			context.addMessage(null, mensagem);
		}finally {
			manager.close();
		}
	}
}
