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
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdNotas", query = "SELECT n FROM Notas n WHERE n.idNotas = :idNotas"),
    @NamedQuery(name = "Notas.findByData", query = "SELECT n FROM Notas n WHERE n.data = :data"),
    @NamedQuery(name = "Notas.findByTitulo", query = "SELECT n FROM Notas n WHERE n.titulo = :titulo"),
    @NamedQuery(name = "Notas.findByNota", query = "SELECT n FROM Notas n WHERE n.nota = :nota"),
    @NamedQuery(name = "Notas.findByPeso", query = "SELECT n FROM Notas n WHERE n.peso = :peso")})
public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotas")
    private Integer idNotas;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private int peso;
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

    public Notas() {
    }

    public Notas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Notas(Integer idNotas, int peso) {
        this.idNotas = idNotas;
        this.peso = peso;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
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
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Notas[ idNotas=" + idNotas + " ]";
    }
    
}
