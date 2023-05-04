package com.webservices.entity;


import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class User implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;


}
