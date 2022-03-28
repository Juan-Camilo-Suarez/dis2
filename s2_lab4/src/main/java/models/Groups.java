package models;

import ru.itis.s2_lab4.orm.annotations.Column;
import ru.itis.s2_lab4.orm.annotations.Entity;
import ru.itis.s2_lab4.orm.annotations.Id;


@Entity
public
class Groups {
    @Id
    Long id;
    @Column
    String number;
}


