package com.javen.model;

/**
 * Created by Jay on 2017/6/23.
 */
public class Level {
    private Integer id;
    private Integer level;
    private double discount;
    private Integer credit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", level=" + level +
                ", discount=" + discount +
                ", credit=" + credit +
                '}';
    }
}
