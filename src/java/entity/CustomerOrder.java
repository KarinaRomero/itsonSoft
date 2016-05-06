/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KarinaRomero
 */
@Entity
@Table(name = "customer_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findByIdcustomero", query = "SELECT c FROM CustomerOrder c WHERE c.idcustomero = :idcustomero"),
    @NamedQuery(name = "CustomerOrder.findByAmount", query = "SELECT c FROM CustomerOrder c WHERE c.amount = :amount"),
    @NamedQuery(name = "CustomerOrder.findByDateCreated", query = "SELECT c FROM CustomerOrder c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "CustomerOrder.findByConfirmationNumber", query = "SELECT c FROM CustomerOrder c WHERE c.confirmationNumber = :confirmationNumber")})
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcustomero")
    private Integer idcustomero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmation_number")
    private int confirmationNumber;
    @JoinTable(name = "customer_order_has_product", joinColumns = {
        @JoinColumn(name = "customer_order_idcustomero", referencedColumnName = "idcustomero")}, inverseJoinColumns = {
        @JoinColumn(name = "product_idProduct", referencedColumnName = "idProduct")})
    @ManyToMany
    private List<Product> productList;
    @JoinColumn(name = "customer_idcustomer", referencedColumnName = "idcustomer")
    @ManyToOne(optional = false)
    private Customer customerIdcustomer;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer idcustomero) {
        this.idcustomero = idcustomero;
    }

    public CustomerOrder(Integer idcustomero, BigDecimal amount, Date dateCreated, int confirmationNumber) {
        this.idcustomero = idcustomero;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.confirmationNumber = confirmationNumber;
    }

    public Integer getIdcustomero() {
        return idcustomero;
    }

    public void setIdcustomero(Integer idcustomero) {
        this.idcustomero = idcustomero;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomerIdcustomer() {
        return customerIdcustomer;
    }

    public void setCustomerIdcustomer(Customer customerIdcustomer) {
        this.customerIdcustomer = customerIdcustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcustomero != null ? idcustomero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.idcustomero == null && other.idcustomero != null) || (this.idcustomero != null && !this.idcustomero.equals(other.idcustomero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerOrder[ idcustomero=" + idcustomero + " ]";
    }
    
}
