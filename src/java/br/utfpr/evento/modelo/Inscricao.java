/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_inscricao")
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findById", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.id = :id"),
    @NamedQuery(name = "Inscricao.findByTbEventoId", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.tbEventoId = :tbEventoId"),
    @NamedQuery(name = "Inscricao.findByTbParticipanteId", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.tbParticipanteId = :tbParticipanteId"),
    @NamedQuery(name = "Inscricao.findByQtdatividade", query = "SELECT i FROM Inscricao i WHERE i.qtdatividade = :qtdatividade")})
public class Inscricao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InscricaoPK inscricaoPK;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdatividade", nullable = false)
    //</editor-fold>
    private int qtdatividade;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinTable(name = "tb_inscricao_atividade", joinColumns = {
        @JoinColumn(name = "inscricao_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "atividade_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    //</editor-fold>
    private Collection<Atividade> atividades;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "tb_participante_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa pessoa;
    
    //<editor-fold defaultstate="collapsed" desc="anotacões">
    @JoinColumn(name = "tb_evento_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Evento evento;

    public Inscricao() {
    }

    public Inscricao(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public Inscricao(InscricaoPK inscricaoPK, int qtdatividade) {
        this.inscricaoPK = inscricaoPK;
        this.qtdatividade = qtdatividade;
    }

    public Inscricao(int id, int tbEventoId, int tbParticipanteId) {
        this.inscricaoPK = new InscricaoPK(id, tbEventoId, tbParticipanteId);
    }

    public InscricaoPK getInscricaoPK() {
        return inscricaoPK;
    }

    public void setInscricaoPK(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public int getQtdatividade() {
        return qtdatividade;
    }

    public void setQtdatividade(int qtdatividade) {
        this.qtdatividade = qtdatividade;
    }

    public Collection<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Collection<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscricaoPK != null ? inscricaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.inscricaoPK == null && other.inscricaoPK != null) || (this.inscricaoPK != null && !this.inscricaoPK.equals(other.inscricaoPK))) {
            return false;
        }
        return true;
    }
    
}
