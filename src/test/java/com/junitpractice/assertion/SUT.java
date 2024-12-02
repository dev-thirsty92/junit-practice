package com.junitpractice.assertion;

import net.bytebuddy.implementation.bytecode.Throw;
import org.mockito.internal.stubbing.answers.ThrowsException;

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

    public void run(int milliseconds) throws InterruptedException, NoJobException {

        if(getCurrentJob() == null){
            throw new NoJobException("테스트 대상 시스템은 현재 작업이 없는지 확인");
        }
        sleep(milliseconds);
    }

    public void run() throws NoJobException {
        if(getCurrentJob() == null){
            throw new NoJobException("테스트 대상 시스템은 현재 작업이 없는지 확인");
        }
    }
}
