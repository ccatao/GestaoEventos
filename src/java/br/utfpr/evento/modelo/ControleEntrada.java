package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "controle_entrada")
@SequenceGenerator(name="ControleEntradaGen" , allocationSize=1)
public class ControleEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="ControleEntradaGen", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "ctrl_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctrlEntrada;
    
    @Column(name = "ctrl_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctrlSaida;
    
    @JoinColumns({
        @JoinColumn(name = "prm_id", referencedColumnName = "prm_id"),
        @JoinColumn(name = "lcl_id", referencedColumnName = "lcl_id")})
    @ManyToOne(optional = false)
    private LocalProgramacao localProgramacao;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public ControleEntrada() {
    }

    public ControleEntrada(Integer cteId) {
        this.id = cteId;
    }

    public Integer getCteId() {
        return id;
    }

    public void setCteId(Integer cteId) {
        this.id = cteId;
    }

    public Date getCteEntrada() {
        return ctrlEntrada;
    }

    public void setCteEntrada(Date cteEntrada) {
        this.ctrlEntrada = cteEntrada;
    }

    public Date getCteSaida() {
        return ctrlSaida;
    }

    public void setCteSaida(Date cteSaida) {
        this.ctrlSaida = cteSaida;
    }

    public LocalProgramacao getLocalProgramacao() {
        return localProgramacao;
    }

    public void setLocalProgramacao(LocalProgramacao localProgramacao) {
        this.localProgramacao = localProgramacao;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
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
        if (!(object instanceof ControleEntrada)) {
            return false;
        }
        ControleEntrada other = (ControleEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ControleEntrada[ cteId=" + id + " ]";
    }
    
}
