package kh.edu.istad.restapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")

public class Customer {
    @Id

    private UUID id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 50)
    private String address;

    @Column(unique = true, length = 12, nullable = false)
    private String phoneNumber;


    private Boolean isDeleted;

    @OneToOne
    private User user;
}
