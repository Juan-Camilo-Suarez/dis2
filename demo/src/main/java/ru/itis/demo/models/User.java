package ru.itis.demo.models;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personIdGenerator")
    @SequenceGenerator(name = "personIdGenerator", sequenceName = "user_seq", allocationSize=1)
    private Long id;

    private String name;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return hashPassword(password);
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }
    public static String hashPassword(String password_plaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
