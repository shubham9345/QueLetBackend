package com.QueLet.QueLet.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class JwtResponse {
    private String jwtToken;
    private String username;
}

