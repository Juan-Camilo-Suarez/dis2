package models;

import ru.itis.s2_lab4.orm.annotations.Column;
import ru.itis.s2_lab4.orm.annotations.Entity;
import ru.itis.s2_lab4.orm.annotations.Id;


@Entity
public class Cars {
    @Id
    Long id_car;
    @Column
    String mark;
    @Column
    String country;
}
