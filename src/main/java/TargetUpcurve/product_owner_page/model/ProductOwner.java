package TargetUpcurve.product_owner_page.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_owners")

public class ProductOwner {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long product_owner_id;

    @Column(name="Product_owner_firstname",nullable = false)
    private String firstname;

    @Column(name="Product_owner_lastname")
    private String lastname;

    @Column(name="Email_Id")
    private String emailId;

    @Column(name="Product_Name")
    private String product_Name;


    @Column(name="Product_Type")
    private String product_Type;


}
