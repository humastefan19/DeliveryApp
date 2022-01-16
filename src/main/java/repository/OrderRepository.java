package repository;

import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import utils.OrderStatus;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Modifying
    @Query
    Order updateStatus(OrderStatus status);
}
