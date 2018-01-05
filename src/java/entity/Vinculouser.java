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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YerkoAndrei
 */
@Entity
@Table(name = "vinculouser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vinculouser.findAll", query = "SELECT v FROM Vinculouser v"),
    @NamedQuery(name = "Vinculouser.findById", query = "SELECT v FROM Vinculouser v WHERE v.id = :id")})
public class Vinculouser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_comentario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comentarios idComentario;
    @JoinColumn(name = "user", referencedColumnName = "user")
    @ManyToOne(optional = false)
    private Usuario user;

    public Vinculouser() {
    }

    public Vinculouser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comentarios getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Comentarios idComentario) {
        this.idComentario = idComentario;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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
        if (!(object instanceof Vinculouser)) {
            return false;
        }
        Vinculouser other = (Vinculouser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vinculouser[ id=" + id + " ]";
    }
    
}
