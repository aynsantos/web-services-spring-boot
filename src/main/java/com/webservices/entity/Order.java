package com.webservices.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservices.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    /* O código abaixo utiliza getters e setters personalizados para uma melhor pratica do tipo enumerado(OrderStatus),
    proporcionando uma manutenibilidade maior no software. Portanto, mesmo utilizando lombok,nessa entidade em especifico não usamos construtor gerado automaticamente.  */

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

}
