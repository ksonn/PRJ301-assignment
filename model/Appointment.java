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
public class Appointment {
    private String hname;
    private Date hdob;
    private boolean hgender;
    private String haddress;
    private String hphone;
    private String email;
    private String note;
    private Date daysend;

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Date getHdob() {
        return hdob;
    }

    public void setHdob(Date hdob) {
        this.hdob = hdob;
    }

    public boolean isHgender() {
        return hgender;
    }

    public void setHgender(boolean hgender) {
        this.hgender = hgender;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDaysend() {
        return daysend;
    }

    public void setDaysend(Date daysend) {
        this.daysend = daysend;
    }
    
}
