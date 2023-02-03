package com.himal.malla.himal.Service;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> saveAll(List<Order> orderList) {
        return orderRepo.saveAll(orderList);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepo.findById(order.getOrderId()).orElse(null);
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setUser(order.getUser());
        return orderRepo.save(existingOrder);
    }

    public String deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
        return "Order has been removed " + orderId ;
    }
    
        public Order createOrder(Order order) {
        //pseudoCode
        //if that user is exist
        //if it does exist ->>> check if product exist
        //yes ->>true
        // We need to calculate the sales tax, total amount,
        //response "order successfully created "
        //no ->>false
        //return "give message"
        //if it doesn't exist ->>>
        User existingUser = userRepo.findById(order.getUser().getUserId()).get();
        if (existingUser != null) {
            Product existingProduct = productRepo.findById(order.getProduct().getProductId()).get();


            if (existingProduct != null) {


                // existingProduct.getPrice();
                // order.getQuantity();

                int amount = existingProduct.getPrice() * order.getQuantity();
                order.setPrice(amount);

                //user info , product info, quanty, totalmount (price) save to db
                //call orderrepo save

                //give 5% discount if you've ordered more than $100 of amount


            } else if (existingProduct.getPrice()>=100) {
                int discountAmt = (existingProduct.getPrice() * order.getQuantity()) *(5/100);
                int afterDiscount = (existingProduct.getPrice() * order.getQuantity()) -discountAmt;
                order.setPrice(afterDiscount);

            }

        }

        return orderRepo.save(order);
    }
}
