package ir.maktab.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "number")
    Integer number;

    @Column(name = "state")
    String State;

    @Column(name = "city")
    String city;

    @Column(name = "postal_code")
    String postalCode;

    @Column(name = "postal_address")
    String postalAddress;
}
