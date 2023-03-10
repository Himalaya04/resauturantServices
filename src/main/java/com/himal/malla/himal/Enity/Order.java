package com.himal.malla.himal.Enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "order_details")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date")
    private String orderDate;

    private  Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    @JsonIgnoreProperties("orderList")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_id")
    private Product product;


}
