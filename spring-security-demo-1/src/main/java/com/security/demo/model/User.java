package com.security.demo.model;

import java.util.Set;

import jakarta.persistence.* ; 
import lombok.* ; 


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id  ; 

    @Column(name = "username")
    private String username  ; 

    @Column(name = "password")
    private String password ; 


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities" , 
        joinColumns = @JoinColumn(name = "user_id") ,    /*  */
        inverseJoinColumns = @JoinColumn(name = "authority_id")   /*  */
    )
    private Set<Authority> authorities ;

}
