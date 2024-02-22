package com.company.gamestore.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tshirt")
public class T_Shirt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tshirt_id")
    private int id;

    @NotEmpty(message = "You must enter a value for size")
    @Size(max = 20, message = "You must enter a value less than 20 characters for size")
    private String size;

    @NotEmpty(message = "You must enter a value for color")
    @Size(max = 20, message = "You must enter a value less than 20 characters for color")
    private String color;

    @NotEmpty(message = "You must enter a value for description")
    @Size(max = 255, message = "You must enter a value less than 255 characters for description")
    private String description;

    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @Min(value = 0, message = "Quantity cannot be negative.")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_Shirt t_shirt = (T_Shirt) o;
        return id == t_shirt.id && quantity == t_shirt.quantity && size.equals(t_shirt.size) && color.equals(t_shirt.color) && description.equals(t_shirt.description) && price.equals(t_shirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }
}
