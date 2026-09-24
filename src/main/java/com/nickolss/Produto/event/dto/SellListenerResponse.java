package com.nickolss.Produto.event.dto;

public record SellListenerResponse(
        Long productId,
        Integer quantity,
        String message) {
}
