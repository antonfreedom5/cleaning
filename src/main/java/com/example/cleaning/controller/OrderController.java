package com.example.cleaning.controller;

import com.example.cleaning.entity.Order;
import com.example.cleaning.service.ClientService;
import com.example.cleaning.service.DriverService;
import com.example.cleaning.service.OrderService;
import com.example.cleaning.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;
    private final DriverService driverService;
    private final StatusService statusService;

    public OrderController(OrderService orderService, ClientService clientService, DriverService driverService, StatusService statusService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.driverService = driverService;
        this.statusService = statusService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "order/list-order";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Order order, Model model) {
        model.addAttribute("order", order);
        model.addAttribute("drivers", driverService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("statuses", statusService.getAll());
        return "order/add-order";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Order order, BindingResult bindingResult, Model model) {
        orderService.create(order);
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Order order = orderService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
        model.addAttribute("order", order);
        model.addAttribute("drivers", driverService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("statuses", statusService.getAll());
        return "order/edit-order";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Order order, BindingResult result, Model model) {
        orderService.create(order);
        return "redirect:/order";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/order";
    }
}
