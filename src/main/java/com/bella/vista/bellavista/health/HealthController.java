package com.bella.vista.bellavista.health;


import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.bella.vista.bellavista.common.dto.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthController {
    @GetMapping
    public BaseResponse<Void> health(){
         return  BaseResponse.success();
    }
}
