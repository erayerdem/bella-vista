package com.bella.vista.bellavista.receipt.controller;


import com.bella.vista.bellavista.receipt.dto.ReceiptDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receipts")
public class ReceiptController {


    @PostMapping("coffees/{coffeeId}")
    public void addReceipt(@PathVariable Long coffeeId, @RequestBody ReceiptDto req){

    }
}
