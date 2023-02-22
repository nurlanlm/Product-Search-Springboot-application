package com.nurlan.searchrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private String sku;
    private String name;
    private String description;
    private double unitPrice;
    private boolean active;
    private String imageUrl;



}
