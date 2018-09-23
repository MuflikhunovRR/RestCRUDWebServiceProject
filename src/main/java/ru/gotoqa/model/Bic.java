package ru.gotoqa.model;

import javax.persistence.*;

/**
 * @author Muflikhunov Roman
 */

@Entity
@Table(name = "biclist")
public class Bic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bic")
    private String bic;

    @Column(name = "rc")
    private String rc;

    @Column(name = "nm")
    private String nm;

    @Column(name = "rb")
    private String rb;

    @Column(name = "rn")
    private String rn;

    @Column(name = "intCode")
    private String intCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getRb() {
        return rb;
    }

    public void setRb(String rb) {
        this.rb = rb;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getIntCode() {
        return intCode;
    }

    public void setIntCode(String intCode) {
        this.intCode = intCode;
    }

    @Override
    public String toString() {
        return "Bic{" +
                "id=" + id +
                ", bic='" + bic + '\'' +
                ", rc='" + rc + '\'' +
                ", nm='" + nm + '\'' +
                ", rb='" + rb + '\'' +
                ", rn='" + rn + '\'' +
                ", intCode='" + intCode + '\'' +
                '}';
    }
}