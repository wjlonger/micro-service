package com.coder.base.model;

import java.io.Serializable;
import java.util.Date;

public class DoubleColorBall extends BaseModel implements Serializable {

    private static final long serialVersionUID = -1843045915400377443L;

    public DoubleColorBall(){}

    public DoubleColorBall(Integer id,Integer redball1,Integer redball2,Integer redball3,Integer redball4,Integer redball5,Integer redball6,Integer blueball,Date createdate){
        this.id = id;
        this.redball1 = redball1;
        this.redball2 = redball2;
        this.redball3 = redball3;
        this.redball4 = redball4;
        this.redball5 = redball5;
        this.redball6 = redball6;
        this.blueball = blueball;
        this.createdate = createdate;
    }

    private Integer id;

    private Integer redball1;

    private Integer redball2;

    private Integer redball3;

    private Integer redball4;

    private Integer redball5;

    private Integer redball6;

    private Integer blueball;

    private Date createdate;

    private DoubleColorBallOrder doubleColorBallOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedball1() {
        return redball1;
    }

    public void setRedball1(Integer redball1) {
        this.redball1 = redball1;
    }

    public Integer getRedball2() {
        return redball2;
    }

    public void setRedball2(Integer redball2) {
        this.redball2 = redball2;
    }

    public Integer getRedball4() {
        return redball4;
    }

    public void setRedball4(Integer redball4) {
        this.redball4 = redball4;
    }

    public Integer getRedball3() {
        return redball3;
    }

    public void setRedball3(Integer redball3) {
        this.redball3 = redball3;
    }

    public Integer getRedball5() {
        return redball5;
    }

    public void setRedball5(Integer redball5) {
        this.redball5 = redball5;
    }

    public Integer getRedball6() {
        return redball6;
    }

    public void setRedball6(Integer redball6) {
        this.redball6 = redball6;
    }

    public Integer getBlueball() {
        return blueball;
    }

    public void setBlueball(Integer blueball) {
        this.blueball = blueball;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public DoubleColorBallOrder getDoubleColorBallOrder() {
        return doubleColorBallOrder;
    }

    public void setDoubleColorBallOrder(DoubleColorBallOrder doubleColorBallOrder) {
        this.doubleColorBallOrder = doubleColorBallOrder;
    }
}