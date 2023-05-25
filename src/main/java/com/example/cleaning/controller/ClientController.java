package com.example.cleaning.controller;

import com.example.cleaning.entity.Client;
import com.example.cleaning.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("clients", clientService.getAll());
        return "client/list-client";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Client client, Model model) {
        model.addAttribute("client", client);
        return "client/add-client";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Client client, BindingResult result, Model model) {
        clientService.create(client);
        return "redirect:/client";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Client client = clientService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);

        return "client/edit-client";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Client client, BindingResult result, Model model) {
        clientService.create(client);
        return "redirect:/client";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/client";
    }
}
