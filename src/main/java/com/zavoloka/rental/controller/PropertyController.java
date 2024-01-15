package com.zavoloka.rental.controller;

import com.zavoloka.rental.model.Property;
import com.zavoloka.rental.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public String listProperties(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "property/list";
    }

    @GetMapping("/{id}")
    public String viewProperty(@PathVariable Long id, Model model) {
        Property property = propertyService.getPropertyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid property id: " + id));
        model.addAttribute("property", property);
        return "property/view";
    }

    @GetMapping("/new")
    public String showPropertyForm(Model model) {
        model.addAttribute("property", new Property());
        return "property/form";
    }

    @PostMapping("/new")
    public String saveProperty(@ModelAttribute Property property) {
        propertyService.saveProperty(property);
        return "redirect:/properties";
    }

    @GetMapping("/edit/{id}")
    public String editPropertyForm(@PathVariable Long id, Model model) {
        Property property = propertyService.getPropertyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid property id: " + id));
        model.addAttribute("property", property);
        return "property/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "redirect:/properties";
    }
}
