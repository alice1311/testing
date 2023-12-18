package com.vti.finalexam.controller;

import com.vti.finalexam.DTO.OrderDTO;
import com.vti.finalexam.DTO.ProductDTO;
import com.vti.finalexam.entity.Order;
import com.vti.finalexam.entity.Product;
import com.vti.finalexam.form.OrderFormCreating;
import com.vti.finalexam.form.ProductFormCreating;
import com.vti.finalexam.service.IOrderService;
import com.vti.finalexam.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/orders")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderController {
    @Autowired
    private IOrderService service;
    @GetMapping()
    public ResponseEntity<?> getAllOrders(Pageable pageable, @RequestParam String search){
        Page<Order> entitiesPage = service.getAllOrders(pageable, search);
        Page<OrderDTO> dtoPage = entitiesPage.map(new Function<Order, OrderDTO>() {
            @Override
            public OrderDTO apply(Order order) {
                OrderDTO dto = new OrderDTO(order.getTotal_amount(), order.getOder_date(),order.getOderStatus(), order.getCustomer().getId(), order.getEmployee().getId(), order.getPayment_method().getId());
                return dto;
            }

        });
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderFormCreating formCreating){
        service.customer_createOder(formCreating);
        return new ResponseEntity<String>("Create successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable(name = "id") int id, @RequestBody OrderFormCreating formCreating){
        service.updateOder(id, formCreating);
        return new ResponseEntity<String>("Update successfull!", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable(name = "id") int id){
        Order order = service.getOrderById(id);
        OrderDTO orderDTO = new OrderDTO(order.getTotal_amount(), order.getOder_date(),order.getOderStatus(), order.getCustomer().getId(), order.getEmployee().getId(), order.getPayment_method().getId());
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") int id){
        service.deleteOrder(id);
        return new ResponseEntity<String>("Delete successfull!", HttpStatus.OK);
    }


    @DeleteMapping()
    public void deleteOrders(@RequestParam(name="ids") List<Integer> ids){
        service.deleteOrders(ids);
    }
}