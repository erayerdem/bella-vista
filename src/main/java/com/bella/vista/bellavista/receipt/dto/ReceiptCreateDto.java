package com.bella.vista.bellavista.receipt.dto;

import jakarta.validation.constraints.NotNull;

public record ReceiptCreateDto(
        @NotNull Long coffeeId,
        @NotNull Long equipmentId,
        @NotNull Integer temperature,
        @NotNull Long filterId

) {
}
