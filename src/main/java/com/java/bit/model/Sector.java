package com.java.bit.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sectors")
@Getter
@Setter
@SQLDelete(sql = "UPDATE sectors SET enabled = false WHERE id=?")
@Where(clause = "enabled=true")
public class Sector extends BaseModel implements Serializable {

    private static final long serialVersionUID = -1947503839186674888L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
