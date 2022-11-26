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
@Table(name = "roles")
@Getter
@Setter
@SQLDelete(sql = "UPDATE roles SET enabled = false WHERE id=?")
@Where(clause = "enabled=true")
public class Role extends BaseModel implements Serializable {

    private static final long serialVersionUID = -443040968035191455L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30, nullable = false)
    private String name;

}
