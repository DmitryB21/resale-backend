package com.skypro.resale.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ads")
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String adText;
    private Integer price;

//    private User author; // сделать много объявлений к одному юзеру
//    private Image image; // сделать одна картинка к одному объявлению



}
