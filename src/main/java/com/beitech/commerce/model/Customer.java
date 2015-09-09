package com.beitech.commerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Data
@Entity
@Table( name = "CUSTOMER")
public class Customer {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(min=3, max=100)
    @Column(name = "NAME", nullable = false)
    private String name;

    @Getter @Setter
    @Size(min=3, max=100)
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @JoinTable(name="U_CUSTOMER_PRODUCT", joinColumns = {
            @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Product> products;

}
