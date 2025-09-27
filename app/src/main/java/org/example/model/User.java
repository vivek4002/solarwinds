package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class User {
    @Getter
    private int userId;
    @Getter
    private String name;
    @Getter
    private String email;

    public abstract String getDetails();
}
