package com.hanuman.ecom.repository;

import com.hanuman.ecom.domain.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    default Iterable<Order> getOrderInfo() {
        return findAllByOrderByCustomer_Name();
    }

    Iterable<Order> findAllByOrderByCustomer_Name();

}
