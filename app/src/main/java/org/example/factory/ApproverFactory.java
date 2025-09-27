package org.example.factory;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Approver;
import org.example.model.Category;
import org.example.model.User;

public class ApproverFactory {

    public static List<Approver> getApprovers(String tenantId, Category category) {
        switch (category) {
            case Category.Travel:
                Approver apprver1 = new Approver(1, "001", "email1.com");
                Approver apprver2 = new Approver(2, "002", "email2.com");
                return List.of(apprver1, apprver2);
            case Category.BusinessExpense:
                Approver apprver3 = new Approver(3, "003", "email3.com");
                return List.of(new Approver(4, "004", "email4.com"), apprver3);
        
            default:
                return List.of(new Approver(4, "004", "email4.com"));
        }
    }
    
}
