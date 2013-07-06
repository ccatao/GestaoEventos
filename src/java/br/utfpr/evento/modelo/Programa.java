package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "programa")
@SequenceGenerator(name="ProgramaGen" , allocationSize=1)
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="ProgramaGen", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @JoinColumn(name = "programacao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Programacao programacao;
    

    public Programa() {
    }

    public Programa(Integer progId) {
        this.id = progId;
    }

    public Integer getProgId() {
        return id;
    }

    public void setProgId(Integer progId) {
        this.id = progId;
    }

    public String getProgDescricao() {
        return descricao;
    }

    public void setProgDescricao(String progDescricao) {
        this.descricao = progDescricao;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
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
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
