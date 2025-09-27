package org.example.model;

import org.example.exception.InvalidApprovalException;

public class Approver extends User {

    public Approver(int userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public String getDetails() {
        return this.getName();
    }

    public void approveRequest(Request req) throws InvalidApprovalException {
        req.approveRequest(this);
    }

    public void rejectRequest(Request req, String reason) {
        req.rejectRequest(this, reason);
    }

    void getNotified(Request req, String msg) {
        System.out.println(this.getName() + " got notification: "+ msg + " reqid: " + req.getReqestId());
    }
    
}
