package com.poly.lab7.Entity;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable{
    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}