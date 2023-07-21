package org.trading.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trading.orderms.entity.Order;

/**
 * @author Mehman on 18-07-2023
 * @project product-ms
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
