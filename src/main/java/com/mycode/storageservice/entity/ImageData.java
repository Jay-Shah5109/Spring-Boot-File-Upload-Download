package com.mycode.storageservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ImageData")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;
}
