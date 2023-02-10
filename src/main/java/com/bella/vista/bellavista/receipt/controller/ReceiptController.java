package com.bella.vista.bellavista.receipt.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.receipt.dto.ReceiptCreateDto;
import com.bella.vista.bellavista.receipt.dto.ReceiptDto;
import com.bella.vista.bellavista.receipt.entity.Receipt;
import com.bella.vista.bellavista.receipt.service.ReceiptService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("receipts")
@RequiredArgsConstructor
public class ReceiptController {


    private  final ReceiptService receiptService;
    /*@PostMapping("coffees/{coffeeId}")
    public void addReceipt(@PathVariable Long coffeeId, @RequestBody ReceiptDto req){}*/


    @GetMapping
    public BaseResponse<List<Receipt>> receipts(@RequestParam Integer size , @RequestParam Integer page) {
        return BaseResponse.<List<Receipt>>builder().data(receiptService.receipts(page,size,"id")).build();
    }

    @PostMapping
    public BaseResponse<Receipt> receipts(@RequestBody @Valid ReceiptCreateDto req) {
        Receipt receipt = receiptService.createReceipt(req);
        return BaseResponse.<Receipt>builder().data(receipt).build();
    }
}
