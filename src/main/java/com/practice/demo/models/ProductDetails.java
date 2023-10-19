package com.practice.demo.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Embeddable
@AttributeOverrides({
    @AttributeOverride( name = "stockCount", column = @Column(name = "pd_stock_count")),
    @AttributeOverride( name = "isAvailable", column = @Column(name = "pd_is_available")),
})
public class ProductDetails {
    @Setter
    private Integer stockCount;

    @Setter
    private Boolean isAvailable;
}
