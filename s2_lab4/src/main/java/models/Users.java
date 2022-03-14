package models;


import ru.itis.s2_lab4.orm.annotations.Column;
import ru.itis.s2_lab4.orm.annotations.Entity;
import ru.itis.s2_lab4.orm.annotations.Id;
import ru.itis.s2_lab4.orm.annotations.ManyToOne;

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
    @ManyToOne
    Groups group_id;

}
