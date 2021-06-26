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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut")
    , @NamedQuery(name = "Cliente.findByClave", query = "SELECT c FROM Cliente c WHERE c.clave = :clave")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByAppaterno", query = "SELECT c FROM Cliente c WHERE c.appaterno = :appaterno")
    , @NamedQuery(name = "Cliente.findByApmaterno", query = "SELECT c FROM Cliente c WHERE c.apmaterno = :apmaterno")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByNumeracion", query = "SELECT c FROM Cliente c WHERE c.numeracion = :numeracion")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "appaterno")
    private String appaterno;
    @Size(max = 45)
    @Column(name = "apmaterno")
    private String apmaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeracion")
    private int numeracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @JoinColumn(name = "Comuna_idComuna", referencedColumnName = "idComuna")
    @ManyToOne(optional = false)
    private Comuna comunaidComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienterut")
    private List<Solicitud> solicitudList;

    public Cliente() {
    }

    public Cliente(String rut) {
        this.rut = rut;
    }

    public Cliente(String rut, String clave) {
        this.rut = rut;
        this.clave = clave;
    }
    
    

    public Cliente(String rut, String clave, String nombre, String appaterno, String direccion, int numeracion, int telefono) {
        this.rut = rut;
        this.clave = clave;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.direccion = direccion;
        this.numeracion = numeracion;
        this.telefono = telefono;
    }

    public Cliente(String rut, String clave, String nombre, String appaterno, String apmaterno, String direccion, int numeracion, Comuna comunaidComuna, int telefono) {
        this.rut = rut;
        this.clave = clave;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.direccion = direccion;
        this.numeracion = numeracion;
        this.comunaidComuna = comunaidComuna;
        this.telefono = telefono;        
    }
    
    

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Comuna getComunaidComuna() {
        return comunaidComuna;
    }

    public void setComunaidComuna(Comuna comunaidComuna) {
        this.comunaidComuna = comunaidComuna;
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
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ rut=" + rut + " ]";
    }
    
    public String nombreCompleto(){
        return this.nombre+" "+this.appaterno+" "+this.apmaterno;
    }
    
    public String direccionCompleta(){
        return this.direccion+" #"+this.numeracion;
    }
    
}
