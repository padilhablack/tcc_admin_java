/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdmaterial", query = "SELECT m FROM Material m WHERE m.idmaterial = :idmaterial"),
    @NamedQuery(name = "Material.findByTipo", query = "SELECT m FROM Material m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Material.findByAutor", query = "SELECT m FROM Material m WHERE m.autor = :autor"),
    @NamedQuery(name = "Material.findByTitulo", query = "SELECT m FROM Material m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Material.findByAno", query = "SELECT m FROM Material m WHERE m.ano = :ano"),
    @NamedQuery(name = "Material.findByData", query = "SELECT m FROM Material m WHERE m.data = :data"),
    @NamedQuery(name = "Material.findByAssunto", query = "SELECT m FROM Material m WHERE m.assunto = :assunto"),
    @NamedQuery(name = "Material.findByEditora", query = "SELECT m FROM Material m WHERE m.editora = :editora"),
    @NamedQuery(name = "Material.findBySerie", query = "SELECT m FROM Material m WHERE m.serie = :serie"),
    @NamedQuery(name = "Material.findByQuantidade", query = "SELECT m FROM Material m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Material.findByDisponivel", query = "SELECT m FROM Material m WHERE m.disponivel = :disponivel"),
    @NamedQuery(name = "Material.findByFoto", query = "SELECT m FROM Material m WHERE m.foto = :foto")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterial")
    private Integer idmaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "assunto")
    private String assunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "editora")
    private String editora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "disponivel")
    private Integer disponivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaterial")
    private Collection<Emprestimo> emprestimoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaterial")
    private Collection<Reserva> reservaCollection;

    public Material() {
    }

    public Material(Integer idmaterial) {
        this.idmaterial = idmaterial;
    }

    public Material(Integer idmaterial, String tipo, String autor, String titulo, String ano, Date data, String assunto, String editora, String serie, int quantidade, String foto) {
        this.idmaterial = idmaterial;
        this.tipo = tipo;
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.data = data;
        this.assunto = assunto;
        this.editora = editora;
        this.serie = serie;
        this.quantidade = quantidade;
        this.foto = foto;
    }

    public Integer getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(Integer idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterial != null ? idmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idmaterial == null && other.idmaterial != null) || (this.idmaterial != null && !this.idmaterial.equals(other.idmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Material[ idmaterial=" + idmaterial + " ]";
    }
    
}
