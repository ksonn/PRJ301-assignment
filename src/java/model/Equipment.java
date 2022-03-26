/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Equipment {
    
    private int eid;
    private String ename;
    private String source;
    private boolean status;
    private float eprice;
    private Date inputday;

    public Equipment() {
    }

    public Equipment(int eid, String ename, String source, boolean status, float eprice, Date inputday) {
        this.eid = eid;
        this.ename = ename;
        this.source = source;
        this.status = status;
        this.eprice = eprice;
        this.inputday = inputday;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getEprice() {
        return eprice;
    }

    public void setEprice(float eprice) {
        this.eprice = eprice;
    }

    public Date getInputday() {
        return inputday;
    }

    public void setInputday(Date inputday) {
        this.inputday = inputday;
    }
    
    
}
