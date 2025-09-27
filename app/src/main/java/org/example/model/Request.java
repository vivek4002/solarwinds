package org.example.model;


import java.util.*;

import org.example.exception.InvalidApprovalException;
import org.example.factory.ApproverFactory;

import lombok.Getter;

public class Request {

    @Getter
    private String reqestId;
    @Getter
    private String description;
    @Getter
    private Category category;
    @Getter
    private User requster;
    @Getter
    private List<Approver> approvers;
    @Getter
    private long createdTime;
    @Getter
    private Status status;
    @Getter
    private Map<User, RequestStatus> approvalMap;

    
    public Request(int amt, String description, String tenantId, Category category) {
        this.reqestId = UUID.randomUUID().toString();
        this.description = description;
        this.category = category;
        this.createdTime = System.currentTimeMillis();
        this.status = Status.Pending;
        this.approvalMap = new HashMap<>();
        this.approvers = ApproverFactory.getApprovers(tenantId, category);
        for(User approver: this.approvers) {
            approvalMap.put(approver, new RequestStatus(Status.Pending, ""));
        }
        notifyAllApprovers(this, "new Request Received");
    }


    public void approveRequest(Approver approver) throws InvalidApprovalException {
        if(this.status== Status.Rejected) throw new InvalidApprovalException("request already rejected");
        this.approvalMap.put(approver, new RequestStatus(Status.Approved, "approved"));
        boolean isApproved = true;
        for(RequestStatus reqStatus: approvalMap.values()) {
            if(reqStatus.getStatus()!= Status.Approved){
                isApproved = false;
            }
        }
        if(isApproved) this.status = Status.Approved;
        notifyAllApprovers(this, "request has been approved by: "+ approver.getName());
    }

    public void rejectRequest(Approver approver, String reason) {
        this.approvalMap.put(approver, new RequestStatus(Status.Rejected, reason));
        this.status= Status.Rejected;
        notifyAllApprovers(this, "Requst Has Been Rejected");
    }

    // this will notify all the approvers the action of other approvers
    private void notifyAllApprovers(Request req, String msg) {
        for(Approver approver: this.approvers) {
            approver.getNotified(req, msg);
        }
    }







}
