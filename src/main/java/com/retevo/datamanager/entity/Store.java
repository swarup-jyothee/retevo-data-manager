package com.retevo.datamanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties("stores") // Ignore back-reference to avoid infinite loop
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonIgnore // Not needed when creating a store
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonIgnore // Not needed when creating a store
    private List<ShelfDetectionReport> reports;
}
