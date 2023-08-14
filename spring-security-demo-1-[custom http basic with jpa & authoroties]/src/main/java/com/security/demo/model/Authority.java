package com.security.demo.model;

import jakarta.persistence.* ; 
import lombok.* ;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer authority_id ; 

    @Column(name = "name")
    private String name ; 

}
