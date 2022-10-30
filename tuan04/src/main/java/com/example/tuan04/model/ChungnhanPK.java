package com.example.tuan04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"nhanvien", "maybay"})
public class ChungnhanPK implements Serializable {
    private String nhanvien;
    private int maybay;
}
