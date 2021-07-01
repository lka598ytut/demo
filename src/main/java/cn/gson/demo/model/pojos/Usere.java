/**
 * 用户
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Usere {
    private Long userId;//id
    private String userAccount;//账号
    private String userPass;//密码
    private Employee employeeByUserEmp;//员工
    private List<Roleinfo> roleinfos;//角色

    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_ACCOUNT")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "USER_PASS")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usere usere = (Usere) o;
        return Objects.equals(userId, usere.userId) && Objects.equals(userAccount, usere.userAccount) && Objects.equals(userPass, usere.userPass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userAccount, userPass);
    }

    @ManyToOne
    @JoinColumn(name = "USER_EMP", referencedColumnName = "EMP_ID")
    public Employee getEmployeeByUserEmp() {
        return employeeByUserEmp;
    }

    public void setEmployeeByUserEmp(Employee employeeByUserEmp) {
        this.employeeByUserEmp = employeeByUserEmp;
    }

    @ManyToMany
    @JoinTable(name = "USERE_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            }
    )
    public List<Roleinfo> getRoleinfos() {
        return roleinfos;
    }

    public void setRoleinfos(List<Roleinfo> roleinfos) {
        this.roleinfos = roleinfos;
    }

    public Usere(String userAccount, String userPass, Employee employeeByUserEmp, List<Roleinfo> roleinfos) {
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.employeeByUserEmp = employeeByUserEmp;
        this.roleinfos = roleinfos;
    }

    public Usere() {
    }

    @Override
    public String toString() {
        return "Usere{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
