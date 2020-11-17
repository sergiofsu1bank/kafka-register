package br.com.veloe.kafka.si.model;

import java.io.Serializable;

public class IdentificadorDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idIdent;
	private String idEcGrupo;
	private String tipoIdent;
	private String dataAlteracao;
	private String placa;		
	private String ativo;
	private String bloqTemp;
	private String bloqSaldo;
	
	
	public IdentificadorDto(String idIdent, String idEcGrupo, String tipoIdent, String dataAlteracao, String placa,
			String ativo, String bloqTemp, String bloqSaldo) {
		this.idIdent = idIdent;
		this.idEcGrupo = idEcGrupo;
		this.tipoIdent = tipoIdent;
		this.dataAlteracao = dataAlteracao;
		this.placa = placa;
		this.ativo = ativo;
		this.bloqTemp = bloqTemp;
		this.bloqSaldo = bloqSaldo;
	}
	public String getIdIdent() {
		return idIdent;
	}
	public void setIdIdent(String idIdent) {
		this.idIdent = idIdent;
	}
	public String getIdEcGrupo() {
		return idEcGrupo;
	}
	public void setIdEcGrupo(String idEcGrupo) {
		this.idEcGrupo = idEcGrupo;
	}
	public String getTipoIdent() {
		return tipoIdent;
	}
	public void setTipoIdent(String tipoIdent) {
		this.tipoIdent = tipoIdent;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getBloqTemp() {
		return bloqTemp;
	}
	public void setBloqTemp(String bloqTemp) {
		this.bloqTemp = bloqTemp;
	}
	public String getBloqSaldo() {
		return bloqSaldo;
	}
	public void setBloqSaldo(String bloqSaldo) {
		this.bloqSaldo = bloqSaldo;
	}
}