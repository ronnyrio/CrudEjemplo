package com.javatpoint.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table
@Setter
@Getter
public class Artist {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private Date birthDate;

    @Column
    private String style;

    @Column
    private String birthPlace;
}