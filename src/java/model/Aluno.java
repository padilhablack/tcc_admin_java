/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByIdAluno", query = "SELECT a FROM Aluno a WHERE a.idAluno = :idAluno"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findBySenha", query = "SELECT a FROM Aluno a WHERE a.senha = :senha")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAluno")
    private Integer idAluno;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Aulas> aulasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Matricula> matriculaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Notas> notasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Emprestimo> emprestimoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Reserva> reservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Financeiro> financeiroCollection;

    public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<Aulas> getAulasCollection() {
        return aulasCollection;
    }

    public void setAulasCollection(Collection<Aulas> aulasCollection) {
        this.aulasCollection = aulasCollection;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @XmlTransient
    public Collection<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(Collection<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @XmlTransient
    public Collection<Financeiro> getFinanceiroCollection() {
        return financeiroCollection;
    }

    public void setFinanceiroCollection(Collection<Financeiro> financeiroCollection) {
        this.financeiroCollection = financeiroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluno[ idAluno=" + idAluno + " ]";
    }
    
}
