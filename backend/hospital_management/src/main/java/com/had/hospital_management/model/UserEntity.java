package com.had.hospital_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; //email
    private String password;
    private String first_name;
    private String last_name;
    private String gender;
    private Date dob;
    private String address;

    @ManyToOne()
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
    )
    private Role role;
}
