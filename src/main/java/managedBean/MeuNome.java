package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MeuNome {
	private String meuNome;

	public String getMeuNome() {
		return meuNome;
	}

	public void setMeuNome(String meuNome) {
		this.meuNome = meuNome;
	}
	
}
