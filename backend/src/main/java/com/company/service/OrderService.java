package com.company.service;

import com.company.dto.ClientDto;
import com.company.dto.OrderDto;
import com.company.entity.Client;
import com.company.entity.Order;
import com.company.entity.User;
import com.company.repository.ClientRepository;
import com.company.repository.OrderRepository;
import com.company.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    OrderRepository orderRepository;
    UserRepository userRepository;
    ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    public void createOrder(OrderDto orderDto) {
        ClientDto clientDto = orderDto.getClient();

        User user = userRepository.findByUsername(orderDto.getUsername()).get();
        Client clientGenerateId = new Client(clientDto, user);
        clientRepository.save(clientGenerateId);
        LocalDateTime orderedDate = LocalDateTime.now();
        LocalDateTime deliveryDate = orderedDate.plusDays(30);
        String picture = orderDto.getPicture();
        String description = orderDto.getDescription();
        Client client = clientRepository.findClientByEmail(clientDto.getEmail()).get();
        Order order = new Order(client, deliveryDate, orderedDate, description);
        orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).get();
    }

}
