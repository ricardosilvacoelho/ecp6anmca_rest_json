package br.usjt.app_previsoes.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy="cidade")
    private List<Previsao> previsoes;

    private String nome;

    private String latitude;

    private String longitude;

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}
    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Previsao> getPrevisoes() {
		return previsoes;
	}
    
    public String toString() {
        return this.getNome() + " (" + this.getLatitude() + ", "  + this.getLongitude() + ")";
    }
}
