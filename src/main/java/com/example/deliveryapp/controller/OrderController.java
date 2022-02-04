package com.example.deliveryapp.controller;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.OrderService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.UserService;
import com.example.deliveryapp.utils.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final SecurityService securityService;
    private final RestaurantService restaurantService;
    private final UserService userService;
    @GetMapping("/order")
    public String getAllOrders(Model model){
        List<CustomerOrder> customerOrders = orderService.getOrders();
        Long totalOrderCount = (long) orderService.getOrders().size();
        model.addAttribute("totalCount", totalOrderCount);
        model.addAttribute("orders",customerOrders);
        return "orders";
    }

    @GetMapping("/order/{id}")
    public String getOrderForEdit(@PathVariable Long id, Model model){
        CustomerOrder order = orderService.getOrderById(id);
        model.addAttribute("orderEdit", order);
        if(order == null){
            return "orders";
        }else {
            return "changeOrderStatus";
        }
    }

    @PostMapping("/editOrder")
    public String editUser(@ModelAttribute("orderEdit") CustomerOrder orderEdit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "orders";
        }

        orderService.updateOrder(orderEdit);

        return "redirect:/orders";
    }

    @GetMapping("/createOrder")
    public String createOrder(Model model) throws Exception {
        orderService.createOrder();
        List <Restaurant> restaurants =  userService.getUserById(securityService.getCurrentUserId()).map(user ->restaurantService.getNearbyRestaurants(user.getLatitude(), user.getLongitude())).orElseThrow(() -> new Exception("User not found"));
        model.addAttribute("restaurants", restaurants);
        return "restaurants";
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable Long id, Model model){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/ordersHistory")
    public String orderHistory(Model model){
        if(securityService.getCurrentUserRole().contains("USER")){
            List<CustomerOrder> orders = orderService.getOrdersByCustomerId(securityService.getCurrentUserId());
            model.addAttribute("ordersHistory", orders);
        }else if(securityService.getCurrentUserRole().contains("DELIVERY")){
            List<CustomerOrder> orders = orderService.getOrderByDeliveryId(securityService.getCurrentUserId());
            model.addAttribute("ordersHistory", orders);
        }
        return "orderHistory";
    }

    @GetMapping("/viewOrder/{id}")
    public String viewOrder(@PathVariable Long id,Model model){
        CustomerOrder order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        if(order == null){
            return "orders";
        }else {
            return "viewOrder";
        }
    }

    @GetMapping("/moveToPicked/{id}")
    public String moveToPicked(@PathVariable Long id,Model model){
        orderService.pickUpOder(id);
        return "orders";
    }

    @GetMapping("/viewCurrentOrder/{id}")
    public String viewCurrentOrder(@PathVariable Long id,Model model){
        CustomerOrder order = orderService.getCustomerLastOrder(id, OrderStatus.NOT_ORDER);
        model.addAttribute("order", order);
        if(order == null){
            return "orders";
        }else {
            return "viewOrder";
        }
    }

}
