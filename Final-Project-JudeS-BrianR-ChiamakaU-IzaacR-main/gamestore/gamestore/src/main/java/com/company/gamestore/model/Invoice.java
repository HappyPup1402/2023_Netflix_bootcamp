package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @NotEmpty(message = "You must enter a value for name")
    @Size(max = 50, message = "You must enter a value less than 50 characters for name")
    private String name;

    @NotEmpty(message = "You must enter a value for street")
    @Size(max = 100, message = "You must enter a value less than 100 characters for street")
    private String street;

    @NotEmpty(message = "You must enter a value for city")
    @Size(max = 50, message = "You must enter a value less than 50 characters for city")
    private String city;

    @NotEmpty(message = "You must enter a value for state")
    @Size(min = 2, max = 2, message = "You must enter a value of 2 characters for state")
    private String state;

    @NotEmpty(message = "You must enter a value for zipcode")
    @Size(min = 10, max = 10, message = "You must enter a value with exactly 10 digits for zipcode")
    private String zipcode;

    @NotEmpty(message = "You must enter a value for item type")
    @Size(max = 50, message = "You must enter a value less than 50 characters for item type")
    @Column(name = "item_type")
    private String itemType;

    @NotEmpty(message = "You must enter a value for item id")
    @Column(name = "item_id")
    private int itemId;

    @Column(precision = 8, scale = 2, name = "unit_price")
    private BigDecimal unitPrice;

    @NotEmpty(message = "You must enter a value for quantity")
    private int quantity;

    @Column(precision = 8, scale = 2)
    private BigDecimal subtotal;

    @Column(precision = 8, scale = 2)
    private BigDecimal tax;

    @Column(precision = 8, scale = 2, name = "processing_fee")
    private BigDecimal processingFee;

    @Column(precision = 8, scale = 2)
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && itemId == invoice.itemId && quantity == invoice.quantity && Objects.equals(name, invoice.name) && Objects.equals(street, invoice.street) && Objects.equals(city, invoice.city) && Objects.equals(state, invoice.state) && Objects.equals(zipcode, invoice.zipcode) && Objects.equals(itemType, invoice.itemType) && Objects.equals(unitPrice, invoice.unitPrice) && Objects.equals(subtotal, invoice.subtotal) && Objects.equals(tax, invoice.tax) && Objects.equals(processingFee, invoice.processingFee) && Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
