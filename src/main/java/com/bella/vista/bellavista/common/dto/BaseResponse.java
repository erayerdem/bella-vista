package com.bella.vista.bellavista.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonIgnoreProperties
public class BaseResponse<T> {
    private T data;

    @Builder.Default
    private OperationResult result = OperationResult.SUCCESS;



    @Getter
    @Setter
    static class OperationResult {
        private static  final  OperationResult SUCCESS = new OperationResult(200,"SUCCESS");
        private Integer status;
        private String message;

        public OperationResult(Integer status, String message) {
            this.status = status;
            this.message = message;
        }
    }

    public static  BaseResponse<Void> success(){
        return BaseResponse.<Void>builder().build();
    }

}
