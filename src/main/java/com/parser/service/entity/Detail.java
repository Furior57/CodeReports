package com.parser.service.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    int article;
    @Column
    String gtin;
    @Column(name = "product_name")
    String productName;
    @Column
    String tnved;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "article")
    List<Report> reports;

    public Detail() {
    }

    public Detail(int id, int article, String gtin, String productName, String tnved) {
        this.id = id;
        this.article = article;
        this.gtin = gtin;
        this.productName = productName;
        this.tnved = tnved;
    }

    public Detail(int article, String gtin, String productName, String tnved) {
        this.article = article;
        this.gtin = gtin;
        this.productName = productName;
        this.tnved = tnved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


//    public List<Report> getReports() {
//        return reports;
//    }
//
//    public void setReports(List<Report> reports) {
//        this.reports = reports;
//    }

    public String getTnved() {
        return tnved;
    }

    public void setTnved(String tnved) {
        this.tnved = tnved;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", article=" + article +
                ", gtin=" + gtin +
                ", productName='" + productName + '\'' +
                ", tnved=" + tnved +
                ", reports=" +
                '}';
    }
}
