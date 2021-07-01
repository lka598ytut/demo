/**
 * 职称
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Title {
    private Long titId;//id
    private String titName;//职称
    private Dept deptByTitDept;//部门
    private List<Employee> emp;//员工

    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "TIT_ID")
    public Long getTitId() {
        return titId;
    }

    public void setTitId(Long titId) {
        this.titId = titId;
    }

    @Basic
    @Column(name = "TIT_NAME")
    public String getTitName() {
        return titName;
    }

    public void setTitName(String titName) {
        this.titName = titName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(titId, title.titId) && Objects.equals(titName, title.titName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titId, titName);
    }

    @ManyToOne
    @JoinColumn(name = "TIT_DEPT", referencedColumnName = "DEPT_ID")
    public Dept getDeptByTitDept() {
        return deptByTitDept;
    }

    public void setDeptByTitDept(Dept deptByTitDept) {
        this.deptByTitDept = deptByTitDept;
    }
    @OneToMany(mappedBy = "titles")
    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }
}
