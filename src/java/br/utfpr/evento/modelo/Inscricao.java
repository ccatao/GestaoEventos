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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_inscricao", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findById", query = "SELECT i FROM Inscricao i WHERE i.id = :id"),
    @NamedQuery(name = "Inscricao.findByEventoId", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.id = :eventoId"),
    @NamedQuery(name = "Inscricao.findByParticipanteId", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.participante = :participanteId"),
    @NamedQuery(name = "Inscricao.findByQtdatividade", query = "SELECT i FROM Inscricao i WHERE i.qtdatividade = :qtdatividade")})
public class Inscricao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @EmbeddedId
    //</editor-fold>
    protected InscricaoPK inscricaoPK;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    //</editor-fold>
    private int id;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"quantidade\" não deve ser vazio. Preencha a quantidade de atividades que deseja participar.")
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
    @JoinColumn(name = "participante_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa pessoa;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "evento_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Evento evento;

    public Inscricao() {
    }

    public Inscricao(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public Inscricao(InscricaoPK inscricaoPK, int id, int qtdatividade) {
        this.inscricaoPK = inscricaoPK;
        this.id = id;
        this.qtdatividade = qtdatividade;
    }

    public Inscricao(int eventoId, int participanteId) {
        this.inscricaoPK = new InscricaoPK(eventoId, participanteId);
    }

    public InscricaoPK getInscricaoPK() {
        return inscricaoPK;
    }

    public void setInscricaoPK(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdatividade() {
        return qtdatividade;
    }

    public void setQtdatividade(int qtdatividade) {
        this.qtdatividade = qtdatividade;
    }

    public Collection<Atividade> getAtividadeCollection() {
        return atividades;
    }

    public void setAtividadeCollection(Collection<Atividade> atividadeCollection) {
        this.atividades = atividadeCollection;
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
