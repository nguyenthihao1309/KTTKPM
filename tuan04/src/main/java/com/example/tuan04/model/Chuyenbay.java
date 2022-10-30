package com.example.tuan04.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "chuyenbay")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Chuyenbay {
    @Id
    private String macb;
    private String gadi;
    private String gaden;
    private int dodai;
    private Date giodi;
    private Date gioden;
    private int chiphi;
}
