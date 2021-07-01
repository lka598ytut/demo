/**
 * 权限
 */
package cn.gson.demo.model.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Perm {
    private Long permId;//id
    private String permName;//权限名
    private String permComp;//组件名
    private String permUrl;//组件路径
    private String permImg;//组件图标
    private Long permState;//是否可用:0:是1:否
    private Long permLevel;//权限等级
    private Perm permByPermParent;//上级权限
    private List<Roleinfo> roleinfos;//角色

    @Id
    @GeneratedValue(generator = "LIU")
    @SequenceGenerator(name = "LIU",sequenceName = "liu",initialValue = 1,allocationSize = 1)
    @Column(name = "PERM_ID")
    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    @Basic
    @Column(name = "PERM_NAME")
    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    @Basic
    @Column(name = "PERM_COMP")
    public String getPermComp() {
        return permComp;
    }

    public void setPermComp(String permComp) {
        this.permComp = permComp;
    }

    @Basic
    @Column(name = "PERM_URL")
    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    @Basic
    @Column(name = "PERM_IMG")
    public String getPermImg() {
        return permImg;
    }

    public void setPermImg(String permImg) {
        this.permImg = permImg;
    }

    @Basic
    @Column(name = "PERM_STATE")
    public Long getPermState() {
        return permState;
    }

    public void setPermState(Long permState) {
        this.permState = permState;
    }

    @Basic
    @Column(name = "PERM_LEVEL")
    public Long getPermLevel() {
        return permLevel;
    }

    public void setPermLevel(Long permLevel) {
        this.permLevel = permLevel;
    }

    @ManyToMany
    @JoinTable(name = "ROLE_PERM",
            joinColumns = {
                    @JoinColumn(name = "PERM_ID"),
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perm perm = (Perm) o;
        return Objects.equals(permId, perm.permId) && Objects.equals(permName, perm.permName) && Objects.equals(permComp, perm.permComp) && Objects.equals(permUrl, perm.permUrl) && Objects.equals(permImg, perm.permImg) && Objects.equals(permState, perm.permState) && Objects.equals(permLevel, perm.permLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permId, permName, permComp, permUrl, permImg, permState, permLevel);
    }

    @ManyToOne
    @JoinColumn(name = "PERM_PARENT", referencedColumnName = "PERM_ID")
    public Perm getPermByPermParent() {
        return permByPermParent;
    }

    public void setPermByPermParent(Perm permByPermParent) {
        this.permByPermParent = permByPermParent;
    }
}
