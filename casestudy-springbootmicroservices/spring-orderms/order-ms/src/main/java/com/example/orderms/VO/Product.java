package com.example.orderms.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long prodId;
    private String prodName;
    private Long prodCost;
    private Long prodQty;
}
