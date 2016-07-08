package org.lby.kq.model;

/**
 * Created by 邹宇泉 on 2016/7/8.
 */
public class Anay_tj {
    private String name;
    private String deptName;
    private Integer count_cd;//迟到
    private Integer count_zt;//早退
    private Integer count_kg;//旷工
    private Integer count_wc;//外出
    private Integer count_qj;//请假
    private Integer count_cc;//出差

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCount_cd() {
        return count_cd;
    }

    public void setCount_cd(Integer count_cd) {
        this.count_cd = count_cd;
    }

    public Integer getCount_zt() {
        return count_zt;
    }

    public void setCount_zt(Integer count_zt) {
        this.count_zt = count_zt;
    }

    public Integer getCount_kg() {
        return count_kg;
    }

    public void setCount_kg(Integer count_kg) {
        this.count_kg = count_kg;
    }

    public Integer getCount_wc() {
        return count_wc;
    }

    public void setCount_wc(Integer count_wc) {
        this.count_wc = count_wc;
    }

    public Integer getCount_qj() {
        return count_qj;
    }

    public void setCount_qj(Integer count_qj) {
        this.count_qj = count_qj;
    }

    public Integer getCount_cc() {
        return count_cc;
    }

    public void setCount_cc(Integer count_cc) {
        this.count_cc = count_cc;
    }

    @Override
    public String toString() {
        return "Anay_tj{" +
                "name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", count_cd=" + count_cd +
                ", count_zt=" + count_zt +
                ", count_kg=" + count_kg +
                ", count_wc=" + count_wc +
                ", count_qj=" + count_qj +
                ", count_cc=" + count_cc +
                '}';
    }
}
