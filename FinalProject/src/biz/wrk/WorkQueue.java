package biz.wrk;

import java.util.ArrayList;

public abstract class WorkQueue<WorkRequest> {
    private ArrayList<WorkRequest> queue;

    public WorkQueue() {
        this.queue = new ArrayList<>();
    }

    public void addRequest(WorkRequest req) {
        this.queue.add(req);
    }

    public ArrayList<WorkRequest> getQueue() {
        return queue;
    }
}
