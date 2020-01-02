package br.com.isl.alertasamu.model.enums;

public enum StatusAlerta {
	
	ABERTO(1, "Aberto"),
	PENDENTE (2, "Pendente" ),
	FINALIZADO (3, "Finalizado");
	
	private int cod;
	private String descricao;
	
	private StatusAlerta(int cod, String descricao ) {
		this.cod = cod;
		this.descricao = descricao;			
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
    
	//metodo que roda um objeto mesmo sem estar instanciado.
	public static StatusAlerta toEnum(Integer cod) {
		if(cod == null) {
		
			return null;
			
		}
    
    //percorre todos os valores possíveis do meu status de alerta.
    for(StatusAlerta x : StatusAlerta.values()) {
			
			if(cod.equals(x.getCod())) {
				
				return x;
			}
			
		}
	throw new IllegalArgumentException("Id invalido: " + cod);
		
	}
	

}
