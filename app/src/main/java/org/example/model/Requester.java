package org.example.model;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Requester extends User {
    @Getter
    private String tenantId;
    @Getter
    private List<Request> requestsMade;
    public Requester(int userId, String name, String email, String tenantId) {
        super(userId, name, email);
        this.tenantId = tenantId;
        requestsMade = new ArrayList<>();
    }

    @Override
    public String getDetails() {
        return this.getName();
    }

    public Request submitRequest(int amt, String description, Category category){
        Request req = new Request(amt, description, this.tenantId, category);
        requestsMade.add(req);
        return req;
    }

    
}
