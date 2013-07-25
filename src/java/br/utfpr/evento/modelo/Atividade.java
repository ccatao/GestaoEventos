/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tb_atividade")
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findById", query = "SELECT a FROM Atividade a WHERE a.id = :id"),
    @NamedQuery(name = "Atividade.findByDescricao", query = "SELECT a FROM Atividade a WHERE a.descricao LIKE :descricao"),
    @NamedQuery(name = "Atividade.findByDuracao", query = "SELECT a FROM Atividade a WHERE a.duracao = :duracao"),
    @NamedQuery(name = "Atividade.findByDataAtividade", query = "SELECT a FROM Atividade a WHERE a.dataAtividade = :dataAtividade"),
    @NamedQuery(name = "Atividade.findByHoraInicio", query = "SELECT a FROM Atividade a WHERE a.horaInicio = :horaInicio")})
public class Atividade implements Serializable {
    
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
    @NotNull(message = "O campo \"duração\" não deve ser vazio.")
    @Column(name = "duracao", nullable = false)
    //</editor-fold>
    private double duracao;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"data da atividade\" não deve ser vazio.")
    @Column(name = "data_atividade", nullable = false)
    @Temporal(TemporalType.DATE)
    //</editor-fold>
    private Date dataAtividade;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"hora de início\" não deve ser vazio.")
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    //</editor-fold>
    private Date horaInicio;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @ManyToMany(mappedBy = "atividades")
    //</editor-fold>
    private Collection<Evento> eventos;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @ManyToMany(mappedBy = "atividades")
    //</editor-fold>
    private Collection<Inscricao> inscricoes;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "local_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Local local;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa responsavel;

    public Atividade() {
    }

    public Atividade(Integer id) {
        this.id = id;
    }

    public Atividade(Integer id, String descricao, double duracao, Date dataAtividade, Date horaInicio) {
        this.id = id;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataAtividade = dataAtividade;
        this.horaInicio = horaInicio;
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

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Collection<Evento> getEvento() {
        return eventos;
    }

    public void setEvento(Collection<Evento> eventos) {
        this.eventos = eventos;
    }

    public Collection<Inscricao> getInscricao() {
        return inscricoes;
    }

    public void setInscricao(Collection<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Local getLocalId() {
        return local;
    }

    public void setLocalId(Local local) {
        this.local = local;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
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
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
