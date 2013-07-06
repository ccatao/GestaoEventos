package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "unidade")
@SequenceGenerator(name="UnidadeGen" , allocationSize=1)
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="UnidadeGen", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao")
    private String descricao;
    
    public Unidade() {
    }

    public Unidade(Integer id) {
        this.id = id;
    }

    public Integer getUndId() {
        return id;
    }

    public void setUndId(Integer id) {
        this.id = id;
    }

    public String getUndDescricao() {
        return descricao;
    }

    public void setUndDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
}
