package com.example.cleaning.controller;

import com.example.cleaning.entity.Driver;
import com.example.cleaning.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("drivers", driverService.getAll());
        return "driver/list-driver";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Driver driver, Model model) {
        model.addAttribute("driver", driver);
        return "driver/add-driver";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Driver driver, BindingResult result, Model model) {
        driverService.create(driver);
        return "redirect:/driver";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Driver driver = driverService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid driver Id:" + id));
        model.addAttribute("driver", driver);

        return "driver/edit-driver";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Driver driver, BindingResult result, Model model) {
        driverService.create(driver);
        return "redirect:/driver";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        driverService.deleteById(id);
        return "redirect:/driver";
    }
}
