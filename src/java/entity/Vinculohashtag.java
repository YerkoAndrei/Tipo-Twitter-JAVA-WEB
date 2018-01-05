/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YerkoAndrei
 */
@Entity
@Table(name = "vinculohashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vinculohashtag.findAll", query = "SELECT v FROM Vinculohashtag v"),
    @NamedQuery(name = "Vinculohashtag.findById", query = "SELECT v FROM Vinculohashtag v WHERE v.id = :id"),
    @NamedQuery(name = "Vinculohashtag.findByHashtag", query = "SELECT v FROM Vinculohashtag v WHERE v.hashtag = :hashtag")})
public class Vinculohashtag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "hashtag")
    private String hashtag;
    @JoinColumn(name = "id_comentario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comentarios idComentario;

    public Vinculohashtag() {
    }

    public Vinculohashtag(Integer id) {
        this.id = id;
    }

    public Vinculohashtag(Integer id, String hashtag) {
        this.id = id;
        this.hashtag = hashtag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Comentarios getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Comentarios idComentario) {
        this.idComentario = idComentario;
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
        if (!(object instanceof Vinculohashtag)) {
            return false;
        }
        Vinculohashtag other = (Vinculohashtag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vinculohashtag[ id=" + id + " ]";
    }
    
}
