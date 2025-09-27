package org.example.model;

import lombok.Getter;

public class RequestStatus {
    @Getter
    private Status status;
    @Getter
    private String description;
    @Getter
    private long statusChangeDate;

    public RequestStatus(Status status, String desc) {
        this.status = status;
        this.description = desc;
        this.statusChangeDate = System.currentTimeMillis();
    }

}
