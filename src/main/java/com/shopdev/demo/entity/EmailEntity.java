package com.shopdev.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmailEntity {
    private String to;
    private String subject;
    private String body;
    private String attachment;

}
    

