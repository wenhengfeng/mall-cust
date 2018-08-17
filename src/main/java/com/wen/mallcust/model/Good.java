package com.wen.mallcust.model;

import java.math.BigDecimal;

public class Good {
    private Integer id;

    private String goodName;

    private BigDecimal goodPrice;

    private String goodStyle;

    private int goodRemaing;

    private int count;
    public Good() {
    }

    public Good(String goodName, BigDecimal goodPrice, String goodStyle, int goodRemaing) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodStyle = goodStyle;
        this.goodRemaing = goodRemaing;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodStyle() {
        return goodStyle;
    }

    public void setGoodStyle(String goodStyle) {
        this.goodStyle = goodStyle == null ? null : goodStyle.trim();
    }

    public int getGoodRemaing() {
        return goodRemaing;
    }

    public void setGoodRemaing(int goodRemaing) {
        this.goodRemaing = goodRemaing;
    }
}
