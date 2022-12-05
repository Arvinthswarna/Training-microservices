package com.example.customerservicec2.entity;


import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cstId;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "customer_email")
    private String customer_email;

    @Column(name = "customer_phone")
    private Long customer_phone;

    @Column(name = "customer_city")
    private String customer_city;

    @Column(name = "customer_state")
    private String customer_state;

    @Column(name = "customer_country")
    private String customer_country;
}
