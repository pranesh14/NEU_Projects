/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author PRPC
 */
public class WorkRequest {

    private UserAccount sender;
    private UserAccount receiver;
    Status status;
    private String message;
    private Date timeStamp;

    public enum Status {
        SUCCESS, FAILURE, APPROVED, DENIED, TOBETESTED, INPROCESS,
        ORGANIZATION1ADMINAPPROVED, ORGANIZATION2ADMINAPPROVED, ORGANIZATION3ADMINAPPROVED,
        ENTERPRISE1ADMINAPPROVED, ENTERPRISE2ADMINAPPROVED, TOTRIALS, PURCHASEREQUEST,
        TRIALOVERSUCCESS, TRIALOVERFAILURE, TOTESTCENTER, TESTFAILED
    }

    public WorkRequest() {
        timeStamp = new Date();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
