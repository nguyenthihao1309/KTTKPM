package com.example.publisheractivemq.model;

import java.util.Date;

public class Person {
    private long mssv;
    private String hoTen;
    private Date ngaySinh;

    public Person(long mssv, String hoTen, Date ngaySinh) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public Person() {
    }

    public long getMssv() {
        return mssv;
    }

    public void setMssv(long mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mssv=" + mssv +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                '}';
    }
}
