package br.com.isl.alertasamu.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.isl.alertasamu.model.Alerta;

public class AlertaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
 

	private Long id;
	private Date instante;
	private double latitude;
	private double longitude;
	private String observacao;
	private byte[] foto;
	
	public AlertaDTO() {
		
		
	}
	public AlertaDTO(Alerta obj) {
		
		id = obj.getId();
		instante = obj.getInstante();
		latitude = obj.getLatitude();
		longitude = obj.getLongitude();
		observacao = obj.getObservacao();
		foto = obj.getFoto();
		
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
	
	
}
