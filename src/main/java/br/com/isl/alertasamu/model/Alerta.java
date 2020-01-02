package br.com.isl.alertasamu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date instante;
	private double latitude;
	private double longitude;
	private String observacao;
	private byte[] foto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuarioapp")
	private UsuarioApp usuarioapp;

	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "alerta")
	private Atendimento atendimento;

	public Alerta() {

	}

	public Alerta(Long id, Date instante, double latitude, double longitude, String observacao, byte[] foto,
			UsuarioApp usuarioapp) {
		super();
		this.id = id;
		this.instante = instante;
		this.latitude = latitude;
		this.longitude = longitude;
		this.observacao = observacao;
		this.foto = foto;
		this.usuarioapp = usuarioapp;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public UsuarioApp getUsuarioapp() {
		return usuarioapp;
	}

	public void setUsuarioapp(UsuarioApp usuarioapp) {
		this.usuarioapp = usuarioapp;
	}

}
