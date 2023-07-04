package com.skypro.resale.dto;


import lombok.Data;

@Data
public class AdsDto {

    private Integer id_ads;
    private int price;
    private String title;
    private String adText;

    private Integer author;
    private String image;

}
