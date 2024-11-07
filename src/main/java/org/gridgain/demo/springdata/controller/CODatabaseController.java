package org.gridgain.demo.springdata.controller;

import org.gridgain.demo.springdata.model.Customers;
import org.gridgain.demo.springdata.service.CODatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CODatabaseController {
    @Autowired CODatabaseService service;

    @GetMapping("/api/customers")
    public Customers getCustomersById(@RequestParam (value = "id", required = true) int id) {
    	return service.getCustomerById(id);
    }
}