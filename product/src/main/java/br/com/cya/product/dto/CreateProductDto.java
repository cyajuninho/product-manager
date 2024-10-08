package br.com.cya.product.dto;

import java.math.BigDecimal;

public record CreateProductDto(String name, BigDecimal price, Long userId) {
}
