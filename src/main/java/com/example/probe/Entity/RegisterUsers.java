package com.example.probe.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DialectOverride;

@Entity
@Data
@Table
public class RegisterUsers {
    @Id
    public Long id;
@Column(name = "Username")
    public String Username;
@Column(name = "Password")
    public String Password;
        @Column(name = "Roles")
    public String Roles;
}
