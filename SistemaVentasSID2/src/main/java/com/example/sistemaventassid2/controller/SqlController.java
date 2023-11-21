package com.example.sistemaventassid2.controller;

import com.example.sistemaventassid2.model.*;
import com.example.sistemaventassid2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sql")
@CrossOrigin(maxAge = 3600)
public class SqlController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public SqlController(OrderRepository orderRepository, ProductRepository productRepository, CustomerRepository customerRepository, OrderDetailRepository orderDetailRepository, CategoryProductRepository categoryProductRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.categoryProductRepository = categoryProductRepository;
    }

    @PostMapping(value = "/products/category", consumes = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody CategoryProduct categoryProduct) {
        categoryProductRepository.save(categoryProduct);
        return ResponseEntity.ok("Category product placed successfully.");
    }
    @PostMapping(value = "/products", consumes = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("Product placed successfully.");
    }
    @PostMapping(value = "/orders/detail", consumes = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return ResponseEntity.ok("Order detail placed successfully.");
    }

    @PostMapping(value = "/orders", consumes = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok("Order placed successfully.");
    }

    @PostMapping(value = "/customers", consumes = "application/json")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer registered successfully.");
    }

    @PostMapping(value="/customers/getCustomerId",  consumes = "application/json")
    public ResponseEntity<?> getCustomerId(@RequestBody Customer customer) {

        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String address = customer.getAddress();
        String dateOfBirth = customer.getDateOfBirth();
        String email = customer.getEmail();
        String homePhone = customer.getHomePhone();
        String cellPhone = customer.getCellPhone();

        Optional<Long> oCustomerId = customerRepository.findIdByCustomerInfo(firstName,lastName,address,dateOfBirth,email,homePhone,cellPhone);
        if(oCustomerId.isPresent()){
            Long customerId = oCustomerId.get();
            return ResponseEntity.status(200).body(customerId);
        }
        return ResponseEntity.status(400).body("No customer found.");
    }


    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<?> getCategoryProduct(@PathVariable Long categoryId) {
        Optional<CategoryProduct> oCategoryProduct = categoryProductRepository.findById(categoryId);
        if (oCategoryProduct.isPresent()) {
            CategoryProduct categoryProduct = oCategoryProduct.get();
            return ResponseEntity.status(200).body(categoryProduct);
        }
        return ResponseEntity.status(404).body("Category product not found.");
    }
    @GetMapping("/products/categories")
    public ResponseEntity<?> getAllCategoryProducts() {
        List<CategoryProduct> categoryProducts = categoryProductRepository.findAll();
        if (!categoryProducts.isEmpty()) {
            return ResponseEntity.status(200).body(categoryProducts);
        }
        return ResponseEntity.status(404).body("No category products found.");
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        Optional<Product> oProduct = productRepository.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            return ResponseEntity.status(200).body(product);
        }
        return ResponseEntity.status(404).body("Product not found.");
    }

    @GetMapping("/products/all")
    public ResponseEntity<?> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        if (productList.isEmpty()) {
            return ResponseEntity.status(404).body("No products found.");
        }

        return ResponseEntity.status(200).body(productList);
    }


    @GetMapping("/orders")
    public ResponseEntity<?> getOrders(){
        var orders = orderRepository.findAll();
        return ResponseEntity.status(200).body(orders);
    }

    @GetMapping("/orders/detail/{orderId}/{productId}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Long productId,@PathVariable Long orderId) {
        OrderDetailId orderDetailId=new OrderDetailId(productId,orderId);
        Optional<OrderDetail> oOrderDetail = orderDetailRepository.findById(orderDetailId);
        if (oOrderDetail.isPresent()) {
            OrderDetail orderDetail = oOrderDetail.get();
            return ResponseEntity.status(200).body(orderDetail);
        }
        return ResponseEntity.status(404).body("Order detail not found.");
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        Optional<Order> oOrder = orderRepository.findById(orderId);
        if (oOrder.isPresent()) {
            Order order = oOrder.get();
            return ResponseEntity.status(200).body(order);
        }
        return ResponseEntity.status(404).body("Order not found.");
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
        Optional<Customer> oCustomer = customerRepository.findById(customerId);
        if (oCustomer.isPresent()) {
            Customer customer = oCustomer.get();
            return ResponseEntity.status(200).body(customer);
        }
        return ResponseEntity.status(404).body("Customer not found.");
    }

}
