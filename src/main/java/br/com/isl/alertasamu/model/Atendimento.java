package br.com.isl.alertasamu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.isl.alertasamu.model.enums.StatusAlerta;

@Entity
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String observacaoadm;
	private Integer status;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="alerta_id")
	@MapsId
	private Alerta alerta;
	
	@ManyToOne
	@JoinColumn(name="userSamu_id")
	private UsuarioSamu userSamu;

    public Atendimento() {
    	
    	
    }
	
	public Atendimento(Long id,String observacaoadm, StatusAlerta status, Alerta alerta) {
		super();
		this.id = id;
		this.observacaoadm = observacaoadm;
		this.status = status.getCod();
		this.alerta = alerta;
		
	}
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public StatusAlerta getStatus() {
		return StatusAlerta.toEnum(status);
	}


	public void setStatus(StatusAlerta status) {
		this.status = status.getCod();
	}


	public Alerta getAlerta() {
		return alerta;
	}


	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}
	


	public String getObservacaoadm() {
		return observacaoadm;
	}

	public void setObservacao(String observacaoadm) {
		this.observacaoadm = observacaoadm;
	}
	
	

	public UsuarioSamu getUserSamu() {
		return userSamu;
	}

	public void setUserSamu(UsuarioSamu userSamu) {
		this.userSamu = userSamu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
