package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order{
        @Id @GeneratedValue
        @Column(name = "ORDER_ID")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "MEMBER_ID")
        private Member member;

        @OneToOne
        @JoinColumn(name = "DELIVERY_ID")
        private Delivery delivery;

        @OneToMany(mappedBy = "order")
        private List<OrderItem> orderItems = new ArrayList<>();

        private LocalDateTime orderDate;
        @Enumerated(EnumType.STRING)
        private OrderStatus status;

        public void addOrderItem(OrderItem orderItem) {
                orderItems.add(orderItem);
                orderItem.setOrder(this);
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Member getMember() {
                return member;
        }

        public void setMember(Member member) {
                this.member = member;
        }


        public OrderStatus getStatus() {
                return status;
        }

        public void setStatus(OrderStatus status) {
                this.status = status;
        }

        public LocalDateTime getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(LocalDateTime orderDate) {
                this.orderDate = orderDate;
        }
}
