package com.dbserver.agenda.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="agenda")
public class AgendaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome", nullable=false)
	private String nome;

	@Column(name="telefone", nullable=false)
	private String telefone;
	
	@Column(name="local", nullable=false)
	private String local;
	
	@Column(name="data", nullable=false)
	private Date data;
	
	@Transient
	private String dataString;
	
	@Column(name="tipo", nullable=false)
	private String tipo;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getLocal() {
		return local;
	}

	public void setlocal(String local) {
		this.local = local;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setDataStringToData() {
		Date date = new Date();
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(getDataString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setData(date);
	}

}