package dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank String tittle, @NotNull double price, double review) {
    
}
