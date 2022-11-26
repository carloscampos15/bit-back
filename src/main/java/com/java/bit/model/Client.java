package com.java.bit.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "clients")
@Getter
@Setter
@SQLDelete(sql = "UPDATE clients SET enabled = false WHERE id=?")
@Where(clause = "enabled=true")
public class Client extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5257135839798538431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    private Sector sector;

}
