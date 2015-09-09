package com.beitech.commerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Data
@Entity
@Table( name = "PRODUCT")
public class Product {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(min=3, max=100)
    @Column(name = "NAME", nullable = false)
    private String name;

}
