package ru.itis.s2_lab10.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dict_country")
public class Country extends AbstractDictionary {
}