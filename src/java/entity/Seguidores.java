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
@Table(name = "seguidores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguidores.findAll", query = "SELECT s FROM Seguidores s"),
    @NamedQuery(name = "Seguidores.findById", query = "SELECT s FROM Seguidores s WHERE s.id = :id")})
public class Seguidores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "user_seguidor", referencedColumnName = "user")
    @ManyToOne(optional = false)
    private Usuario userSeguidor;
    @JoinColumn(name = "user_seguido", referencedColumnName = "user")
    @ManyToOne(optional = false)
    private Usuario userSeguido;

    public Seguidores() {
    }

    public Seguidores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUserSeguidor() {
        return userSeguidor;
    }

    public void setUserSeguidor(Usuario userSeguidor) {
        this.userSeguidor = userSeguidor;
    }

    public Usuario getUserSeguido() {
        return userSeguido;
    }

    public void setUserSeguido(Usuario userSeguido) {
        this.userSeguido = userSeguido;
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
        if (!(object instanceof Seguidores)) {
            return false;
        }
        Seguidores other = (Seguidores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Seguidores[ id=" + id + " ]";
    }
    
}
