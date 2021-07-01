/**
 * 班次
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Shift {
    private Long shiId;//id
    private String shiName;//班次名
    private Timestamp startTime;//开始时间
    private Timestamp stopTime;//结束时间
    private ShiftType shiftType;//类别


    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "SHI_ID")
    public Long getShiId() {
        return shiId;
    }

    public void setShiId(Long shiId) {
        this.shiId = shiId;
    }

    @Basic
    @Column(name = "SHI_NAME")
    public String getShiName() {
        return shiName;
    }

    public void setShiName(String shiName) {
        this.shiName = shiName;
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

    @ManyToOne
    @JoinColumn(name = "SHI_TYPE", referencedColumnName = "TYPE_ID")
    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public Shift(String shiName, Timestamp startTime, Timestamp stopTime, ShiftType shiftType) {
        this.shiName = shiName;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.shiftType = shiftType;
    }

    public Shift() {
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiId=" + shiId +
                ", shiName='" + shiName + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return Objects.equals(shiId, shift.shiId) && Objects.equals(shiName, shift.shiName) && Objects.equals(startTime, shift.startTime) && Objects.equals(stopTime, shift.stopTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiId, shiName, startTime, stopTime);
    }
}
