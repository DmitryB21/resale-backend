package com.skypro.resale.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mediaType;
    private Long fileSize;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

}