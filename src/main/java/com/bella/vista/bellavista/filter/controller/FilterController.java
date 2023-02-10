package com.bella.vista.bellavista.filter.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.filter.dto.FilterRequestDto;
import com.bella.vista.bellavista.filter.entity.Filter;
import com.bella.vista.bellavista.filter.service.FilterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filters")
@RequiredArgsConstructor
public class FilterController {

    private  final FilterService filterService;
    @GetMapping
    public BaseResponse<List<Filter>> getFilters(){
        var filters = filterService.getFilters();
        return BaseResponse.<List<Filter>>builder().data(filters).build();
    }

    @PostMapping
    public BaseResponse<Filter> getFilter(@Valid @RequestBody FilterRequestDto req){
            return BaseResponse.<Filter>builder().data(filterService.addFilter(req)).build();
    }

    @DeleteMapping("{id}")
    public BaseResponse<Void> deleteFilter(@PathVariable Long id) {
            filterService.deleteFilter(id);
            return BaseResponse.success();
    }

    @GetMapping("{id}")
    public BaseResponse<Filter> getFilter(@PathVariable Long id) {
        var filter = filterService.getById(id);
        return BaseResponse.<Filter>builder().data(filter).build();
    }
}
