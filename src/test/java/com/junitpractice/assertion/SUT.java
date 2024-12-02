package com.junitpractice.assertion;

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
}
