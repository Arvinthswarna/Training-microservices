package com.example.orderms.controller;

import com.example.orderms.VO.ResponseTemplateVO;
import com.example.orderms.entity.OrderOne;
import com.example.orderms.repository.OrderRepository;
import com.example.orderms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public OrderOne saveOrder(@RequestBody OrderOne order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getOrderById(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderOne> updateOrder(@PathVariable("id") Long id, @RequestBody OrderOne order){
        Optional<OrderOne> orderData = orderRepository.findById(id);
        if(orderData.isPresent()){
            OrderOne _order = orderData.get();
            _order.setOrdNumber(order.getOrdNumber());
            _order.setOrdStatus(order.getOrdStatus());

            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") Long id){
        try{
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
