/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id"),
    @NamedQuery(name = "Evento.findByDescricao", query = "SELECT e FROM Evento e WHERE e.descricao LIKE :descricao"),
    @NamedQuery(name = "Evento.findBySituacaoEvento", query = "SELECT e FROM Evento e WHERE e.situacaoEvento.descricao = :situacao"),
    @NamedQuery(name = "Evento.findByResponsavel", query = "SELECT e FROM Evento e WHERE e.responsavel.nome LIKE :nome"),
    @NamedQuery(name = "Evento.findByNome", query = "SELECT e FROM Evento e WHERE e.nome LIKE :nome"),
    @NamedQuery(name = "Evento.findByDataInicio", query = "SELECT e FROM Evento e WHERE e.dataInicio = :dataInicio"),
    @NamedQuery(name = "Evento.findByDataFim", query = "SELECT e FROM Evento e WHERE e.dataFim = :dataFim")})
public class Evento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    //</editor-fold>
    private Integer id;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"descrição\" não deve ser vazio.")
    @Size(min = 5, max = 45, message = "O campo \"descrição\" não deve ter menos que 5 ou mais que 45 caracteres.")
    @Column(name = "descricao", nullable = false, length = 45)
    //</editor-fold>
    private String descricao;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"nome\" não deve ser vazio.")
    @Size(min = 3, max = 45, message = "O campo \"nome\" não deve ter menos que 3 ou mais que 45 caracteres.")
    @Column(name = "nome", nullable = false, length = 45)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"data inicial\" não deve ser vazio.")
    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    //</editor-fold>
    private Date dataInicio;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"data final\" não deve ser vazio.")
    @Column(name = "data_fim", nullable = false)
    @Temporal(TemporalType.DATE)
    //</editor-fold>
    private Date dataFim;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinTable(name = "tb_evento_atividade", joinColumns = {
        @JoinColumn(name = "evento_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "atividade_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    //</editor-fold>
    private Collection<Atividade> atividades;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    //</editor-fold>
    private Collection<Inscricao> inscricoes;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "tipo_evento_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private TipoEvento tipoEvento;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa responsavel;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "situacao_evento_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private SituacaoEvento situacaoEvento;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String descricao, String nome, Date dataInicio, Date dataFim) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Collection<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Collection<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Collection<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricaoCollection(Collection<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public SituacaoEvento getSituacaoEvento() {
        return situacaoEvento;
    }

    public void setSituacaoEvento(SituacaoEvento situacaoEvento) {
        this.situacaoEvento = situacaoEvento;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
