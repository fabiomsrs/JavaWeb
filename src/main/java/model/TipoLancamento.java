package model;

public enum TipoLancamento {
	RECEITA("Receita"),
	DESPESA("Despesa");	
	
	String descricao;
	
	private TipoLancamento(String descricao) {
		// TODO Auto-generated constructor stub
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
