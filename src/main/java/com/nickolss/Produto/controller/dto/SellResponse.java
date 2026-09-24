package com.nickolss.Produto.controller.dto;

public record SellResponse(
        Long productId,
        Integer quantity,
        String message) {

}
