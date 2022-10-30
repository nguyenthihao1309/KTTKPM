package com.example.tuan04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "maybay")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "dsChungnhan")
public class Maybay {
    @Id
    private int mamb;
    private String loai;
    private int tambay;
    @OneToMany(mappedBy = "maybay")
    @JsonBackReference
    private List<Chungnhan> dsChungnhan;
}
