/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByIdAulas", query = "SELECT a FROM Aulas a WHERE a.idAulas = :idAulas"),
    @NamedQuery(name = "Aulas.findByData", query = "SELECT a FROM Aulas a WHERE a.data = :data"),
    @NamedQuery(name = "Aulas.findByDescricao", query = "SELECT a FROM Aulas a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Aulas.findByPresenca", query = "SELECT a FROM Aulas a WHERE a.presenca = :presenca"),
    @NamedQuery(name = "Aulas.findByFalta", query = "SELECT a FROM Aulas a WHERE a.falta = :falta")})
public class Aulas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAulas")
    private Integer idAulas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 250)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2)
    @Column(name = "presenca")
    private String presenca;
    @Size(max = 2)
    @Column(name = "falta")
    private String falta;
    @JoinColumn(name = "idTurma", referencedColumnName = "idTurma")
    @ManyToOne(optional = false)
    private Turma idTurma;
    @JoinColumn(name = "idProfessor", referencedColumnName = "idProfessor")
    @ManyToOne(optional = false)
    private Professor idProfessor;
    @JoinColumn(name = "idPeriodo", referencedColumnName = "idPeriodo")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @JoinColumn(name = "idDisciplina", referencedColumnName = "idDisciplina")
    @ManyToOne(optional = false)
    private Disciplina idDisciplina;
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curso idCurso;
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno")
    @ManyToOne(optional = false)
    private Aluno idAluno;

    public Aulas() {
    }

    public Aulas(Integer idAulas) {
        this.idAulas = idAulas;
    }

    public Aulas(Integer idAulas, Date data) {
        this.idAulas = idAulas;
        this.data = data;
    }

    public Integer getIdAulas() {
        return idAulas;
    }

    public void setIdAulas(Integer idAulas) {
        this.idAulas = idAulas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPresenca() {
        return presenca;
    }

    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public Professor getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAulas != null ? idAulas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.idAulas == null && other.idAulas != null) || (this.idAulas != null && !this.idAulas.equals(other.idAulas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aulas[ idAulas=" + idAulas + " ]";
    }
    
}
