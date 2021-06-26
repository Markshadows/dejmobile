/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
 * @author scarecrow
 */
@Entity
@Table(name = "NAVEGACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navegacion.findAll", query = "SELECT n FROM Navegacion n")
    , @NamedQuery(name = "Navegacion.findByIdNavegacion", query = "SELECT n FROM Navegacion n WHERE n.idNavegacion = :idNavegacion")
    , @NamedQuery(name = "Navegacion.findByDescripcion", query = "SELECT n FROM Navegacion n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Navegacion.findByPrecio", query = "SELECT n FROM Navegacion n WHERE n.precio = :precio")})
public class Navegacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNavegacion")
    private Integer idNavegacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "navegacioncuota")
    private List<Solicitud> solicitudList;

    public Navegacion() {
    }

    public Navegacion(Integer idNavegacion) {
        this.idNavegacion = idNavegacion;
    }

    public Navegacion(Integer idNavegacion, String descripcion, int precio) {
        this.idNavegacion = idNavegacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdNavegacion() {
        return idNavegacion;
    }

    public void setIdNavegacion(Integer idNavegacion) {
        this.idNavegacion = idNavegacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNavegacion != null ? idNavegacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Navegacion)) {
            return false;
        }
        Navegacion other = (Navegacion) object;
        if ((this.idNavegacion == null && other.idNavegacion != null) || (this.idNavegacion != null && !this.idNavegacion.equals(other.idNavegacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Navegacion[ idNavegacion=" + idNavegacion + " ]";
    }
    
}
