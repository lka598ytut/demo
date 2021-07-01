/**
 * 排班
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Schedu {
    private Long scheId;//id
    private Timestamp startTime;//开始时间
    private Timestamp stopTime;//结束时间
    private Timestamp startDate;//开始日期
    private Timestamp stopDate;//结束日期
    private Employee employeeByEmpId;//员工

    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "SCHE_ID")
    public Long getScheId() {
        return scheId;
    }

    public void setScheId(Long scheId) {
        this.scheId = scheId;
    }

    @Basic
    @Column(name = "START_TIME")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "STOP_TIME")
    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    @Basic
    @Column(name = "START_DATE")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "STOP_DATE")
    public Timestamp getStopDate() {
        return stopDate;
    }

    public void setStopDate(Timestamp stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedu schedu = (Schedu) o;
        return Objects.equals(scheId, schedu.scheId) && Objects.equals(startTime, schedu.startTime) && Objects.equals(stopTime, schedu.stopTime) && Objects.equals(startDate, schedu.startDate) && Objects.equals(stopDate, schedu.stopDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheId, startTime, stopTime, startDate, stopDate);
    }

    @ManyToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    public Employee getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Employee employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    public Schedu(Timestamp startTime, Timestamp stopTime, Timestamp startDate, Timestamp stopDate, Employee employeeByEmpId) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.employeeByEmpId = employeeByEmpId;
    }

    public Schedu() {
    }

    @Override
    public String toString() {
        return "Schedu{" +
                "scheId=" + scheId +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                '}';
    }
}
