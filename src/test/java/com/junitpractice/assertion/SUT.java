package com.junitpractice.assertion;

import static java.lang.Thread.sleep;

class SUT {

    private String systemName;
    private boolean isVerified = false;
    private Job currentJob;

    public SUT(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemName() {
        return systemName;
    }

    void verify() {
        this.isVerified = true;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void addJob(Job job1) {
        this.currentJob = job1;
    }

    public void run(int milliseconds) throws InterruptedException {
        sleep(milliseconds);
    }
}
