package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//вспомогательные классы DTO - data transfer object - описывают объекты соответствующие данным в Б
@Entity
@Table(name = "group_list")
public class GroupRecord {
    @Id
    @Column(name = "group_id")
    int id;
    @Column(name = "group_name")
    String group_name;
    @Column(name = "group_header")
    String header;
    @Column(name = "group_footer")
    String footer;
}
