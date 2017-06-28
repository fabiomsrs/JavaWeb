package managedBean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import model.Lancamento;
import repository.LancamentoRepository;
import util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean {
	private List<Lancamento> lancamentos;
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void consultar(){
		EntityManager manager = JpaUtil.getEntityManager();
		LancamentoRepository lancamentoRepository = new LancamentoRepository(manager);		
		this.lancamentos = lancamentoRepository.todos();
		
		manager.close();	
	}
}
