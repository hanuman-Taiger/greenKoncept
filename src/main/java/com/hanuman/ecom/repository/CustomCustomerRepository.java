package com.hanuman.ecom.repository;


import com.hanuman.ecom.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

@Repository
public class CustomCustomerRepository  {

    @Autowired
    EntityManager entityManager;

    public Iterable<Customer> getAllCustomers(String name, String sort, String order) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> customer = query.from(Customer.class);
        query.select(customer);
        Order orderBy = null;


        if (name != null) {
            query.where(customer.get("name").in(name));
        }

        if (sort != null) {
            if ("ASC".equalsIgnoreCase(order)) {
                query.orderBy(builder.asc(customer.get(sort)));
            } else {
                query.orderBy(builder.desc(customer.get(sort)));
            }
        }
        return entityManager.createQuery(query).getResultList();
    }
}
