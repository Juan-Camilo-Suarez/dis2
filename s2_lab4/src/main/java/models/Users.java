package models;


import ru.itis.s2_lab4.orm.annotations.Column;
import ru.itis.s2_lab4.orm.annotations.Entity;
import ru.itis.s2_lab4.orm.annotations.Id;

@Entity
public class Users {
    @Id
    Long id;
    @Column
    String name;
    @Column
    String password;
    @Column
    String role;

    @Column
    int group_id;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        String a = String.format("'%s'", name);
        String b = String.format("'%s'", password);
        String c = String.format("'%s'", role);
        return a + "," + b + "," + c + "," + group_id;
    }
}
