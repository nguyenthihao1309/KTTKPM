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
@Table(name = "nhanvien")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "dsChungnhan")
public class Nhanvien {
    @Id
    private String manv;
    private String ten;
    private int luong;
    @OneToMany(mappedBy = "nhanvien")
    @JsonBackReference
    private List<Chungnhan> dsChungnhan;
}
