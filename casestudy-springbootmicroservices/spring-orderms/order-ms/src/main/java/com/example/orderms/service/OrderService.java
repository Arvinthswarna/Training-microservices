package com.example.orderms.service;


import com.example.orderms.VO.Customer;
import com.example.orderms.VO.Product;
import com.example.orderms.VO.ResponseTemplateVO;
import com.example.orderms.entity.OrderOne;
import com.example.orderms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    public OrderOne saveOrder(OrderOne order) {
        return orderRepository.save(order);
    }

    public ResponseTemplateVO getOrderById(Long id) {
        ResponseTemplateVO rtVO = new ResponseTemplateVO();
        OrderOne order = orderRepository.findByOrdId(id);
        Product product = restTemplate.getForObject("http://localhost:4000/products/"+order.getProdId(),Product.class);
        Customer customer = restTemplate.getForObject("http://localhost:4001/customers/"+order.getCustId(), Customer.class);
        rtVO.setOrder(order);
        rtVO.setCustomer(customer);
        rtVO.setProduct(product);
        return rtVO;
    }
}
