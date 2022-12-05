package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private Date birthDate;

    public Usuario() {
    }
}
