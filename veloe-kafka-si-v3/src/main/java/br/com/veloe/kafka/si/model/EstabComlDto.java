package br.com.veloe.kafka.si.model;

import java.io.Serializable;

public class EstabComlDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String idEcGrupo;
    private String idEc;
    private String tipoEc;
    private String dataAlteracao;
    private String liberado;
    
	public EstabComlDto(String idEcGrupo, String idEc, String tipoEc, String dataAlteracao, String liberado) {
		this.idEcGrupo = idEcGrupo;
		this.idEc = idEc;
		this.tipoEc = tipoEc;
		this.dataAlteracao = dataAlteracao;
		this.liberado = liberado;
	}

	public String getIdEcGrupo() {
		return idEcGrupo;
	}

	public void setIdEcGrupo(String idEcGrupo) {
		this.idEcGrupo = idEcGrupo;
	}

	public String getIdEc() {
		return idEc;
	}

	public void setIdEc(String idEc) {
		this.idEc = idEc;
	}

	public String getTipoEc() {
		return tipoEc;
	}

	public void setTipoEc(String tipoEc) {
		this.tipoEc = tipoEc;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getLiberado() {
		return liberado;
	}

	public void setLiberado(String liberado) {
		this.liberado = liberado;
	}
    
}
