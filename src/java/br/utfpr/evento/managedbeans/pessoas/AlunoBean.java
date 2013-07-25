/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.managedbeans.pessoas;

import br.utfpr.evento.modelo.Aluno;
import br.utfpr.evento.modelo.Cidade;
import br.utfpr.evento.modelo.Estado;
import br.utfpr.evento.persistence.AlunoDAO;
import br.utfpr.evento.persistence.CidadeDAO;
import br.utfpr.evento.persistence.EstadoDAO;
import br.utfpr.evento.persistence.interfaces.InterfaceBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Cleber
 */

@Named
public class AlunoBean implements InterfaceBean<Aluno> {

    private Aluno aluno = new Aluno();
    private List<Cidade> cidades = new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();
    private Estado estado;
    private Cidade cidade;
    private AlunoDAO alunoDAO = new AlunoDAO();
    private String confirmaSenha;
    private Date date;
    private Integer id;

 
    public AlunoBean() {
        aluno = new Aluno();
        CidadeDAO cidade = new CidadeDAO();
        cidades = cidade.listar();
    }
    
       public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String novo() {
        aluno = new Aluno();
        return "";
    }

    @Override
    public String enviar() {

        boolean salvo = true;
        
        FacesContext context = FacesContext.getCurrentInstance();
        
                
        if (salvo) {
                       
            aluno.getUsuario();
         
            if (aluno.getId() == 0) {

                if (alunoDAO.salvar(aluno)) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno Cadastrado!", ""));
                    aluno = new Aluno();
                    return "aluno.pagina.index";
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas no Cadastro!", ""));
                    return "";
                }
            } else {
                if (alunoDAO.atualizar(aluno)) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno Atualizado!", ""));
                    aluno = new Aluno();
                    return "aluno.pagina.index";
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas na Atualização!", ""));
                    return "";
                }
            }

        }
        return "";
    }

    @Override
    public String editar() {
        Aluno aluno = (Aluno) alunoDAO.buscarId(id);
        this.aluno = aluno;
        estado = aluno.getEndereco().getCidadeId().getEstado();
        
        return "aluno.pagina.cadastro";
    }

    @Override
    public String apagar() {
        alunoDAO.remover(aluno);
        return "";
    }

    @Override
    public List<Aluno> listarTodos() {
        // TODO Auto-generated method stub
        return alunoDAO.listar();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void changeCidade(String uf) {
        CidadeDAO cidadeDao = new CidadeDAO();
        cidades = cidadeDao.listarPorEstado(uf);
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Estado> getEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.listar();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
