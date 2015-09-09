package com.beitech.commerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Data
@Entity
@Table( name = "INVOICE")
public class Order {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(min=3, max=100)
    @Column(name = "DELIVERY_ADDRESS")
    private String deliveryAddress;

    @Getter @Setter
    @Column(name = "CURRENCY_RATE")
    private String currencyRate;

    @Getter @Setter
    @Column(name = "DATE")
    private Timestamp date;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
    private Customer customer;

}
