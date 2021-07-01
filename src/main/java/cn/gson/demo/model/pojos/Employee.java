/**
 * 员工
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    private Long empId;//id
    private String empName;//员工名
    private String empPhone;//电话
    private String empCard;//身份证
    private Timestamp empInduction;//入职日期
    private Timestamp empDeparture;//离职日期
    private Long empState;//状态
    private Dept deptByEmpDept;//部门
    private Department departmentByEmpDepar;//科室
    private Title titles;//职称
    private List<Usere> useres;//用户
    private List<Schedu> schedus;//排班

    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "EMP_ID")
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "EMP_NAME")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "EMP_PHONE")
    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Basic
    @Column(name = "EMP_CARD")
    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard;
    }

    @Basic
    @Column(name = "EMP_INDUCTION")
    public Timestamp getEmpInduction() {
        return empInduction;
    }

    public void setEmpInduction(Timestamp empInduction) {
        this.empInduction = empInduction;
    }

    @Basic
    @Column(name = "EMP_DEPARTURE")
    public Timestamp getEmpDeparture() {
        return empDeparture;
    }

    public void setEmpDeparture(Timestamp empDeparture) {
        this.empDeparture = empDeparture;
    }

    @Basic
    @Column(name = "EMP_STATE")
    public Long getEmpState() {
        return empState;
    }

    public void setEmpState(Long empState) {
        this.empState = empState;
    }

    @OneToMany(mappedBy = "employeeByUserEmp")
    public List<Usere> getUseres() {
        return useres;
    }

    public void setUseres(List<Usere> useres) {
        this.useres = useres;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public List<Schedu> getSchedus() {
        return schedus;
    }

    public void setSchedus(List<Schedu> schedus) {
        this.schedus = schedus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(empPhone, employee.empPhone) && Objects.equals(empCard, employee.empCard) && Objects.equals(empInduction, employee.empInduction) && Objects.equals(empDeparture, employee.empDeparture) && Objects.equals(empState, employee.empState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empPhone, empCard, empInduction, empDeparture, empState);
    }

    @ManyToOne
    @JoinColumn(name = "EMP_DEPT", referencedColumnName = "DEPT_ID")
    public Dept getDeptByEmpDept() {
        return deptByEmpDept;
    }

    public void setDeptByEmpDept(Dept deptByEmpDept) {
        this.deptByEmpDept = deptByEmpDept;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_DEPAR", referencedColumnName = "DEPA_ID")
    public Department getDepartmentByEmpDepar() {
        return departmentByEmpDepar;
    }

    public void setDepartmentByEmpDepar(Department departmentByEmpDepar) {
        this.departmentByEmpDepar = departmentByEmpDepar;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_TIT", referencedColumnName = "TIT_ID")
    public Title getTitles() {
        return titles;
    }

    public void setTitles(Title titles) {
        this.titles = titles;
    }

    public Employee(String empName, String empPhone, String empCard, Timestamp empInduction, Timestamp empDeparture, Long empState, Dept deptByEmpDept, Department departmentByEmpDepar, Title titles, List<Usere> useres, List<Schedu> schedus) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.empCard = empCard;
        this.empInduction = empInduction;
        this.empDeparture = empDeparture;
        this.empState = empState;
        this.deptByEmpDept = deptByEmpDept;
        this.departmentByEmpDepar = departmentByEmpDepar;
        this.titles = titles;
        this.useres = useres;
        this.schedus = schedus;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empCard='" + empCard + '\'' +
                ", empInduction=" + empInduction +
                ", empDeparture=" + empDeparture +
                ", empState=" + empState +
                '}';
    }
}
