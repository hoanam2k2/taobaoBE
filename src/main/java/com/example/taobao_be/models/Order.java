package com.example.taobao_be.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_id", nullable = false, length = 50)
    private String orderId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_status", nullable = false)
    private Integer orderStatus;

    @Lob
    @Column(name = "status")// '0: Chưa xác nhận\r\n1: Đã xác nhận\r\n2: Đang giao\r\n3: Giao thành công',\r\n4: Đã hủy
    private String status;

    @Column(name = "delivery_address", nullable = false, length = 225)
    private String deliveryAddress;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "total_money", nullable = false)
    private Double totalMoney;

    @Column(name = "note")
    @Type(type = "org.hibernate.type.TextType")
    private String note;

    @Column(name = "cancel_note")
    @Type(type = "org.hibernate.type.TextType")
    private String cancelNote;

    @Column(name = "ctime", nullable = false)
    private Date ctime;

    @Column(name = "mtime")
    private Date mtime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<OrderDetail> orderDetailList;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderStatus=" + orderStatus +
                ", status='" + status + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", totalMoney=" + totalMoney +
                ", note='" + note + '\'' +
                ", cancelNote='" + cancelNote + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}