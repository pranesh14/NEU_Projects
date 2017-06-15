/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workQueue;

    public WorkQueue() {
        workQueue = new ArrayList<>();
    }

    public WorkRequest addWorkRequest() {
        WorkRequest workRequest = new WorkRequest();
        workQueue.add(workRequest);
        return workRequest;
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }

}
