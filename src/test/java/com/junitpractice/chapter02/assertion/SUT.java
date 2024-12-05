package com.junitpractice.chapter02.assertion;

import static java.lang.Thread.sleep;

public class SUT {

    private String systemName;
    private boolean isVerified = false;
    private Job currentJob;

    public SUT() {
    }

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




    public boolean hasJobToRun() {
        System.out.println("가정문이 통과되었습니다.");
        System.out.println("hasJobToRun() 메서드를 수행합니다.");
        return this.currentJob != null;
    }

    public void run(Job job) throws NoJobException {
        this.currentJob = job;

        if(getCurrentJob() == null){
            throw new NoJobException("테스트 대상 시스템은 현재 작업이 없는지 확인");
        }

    }
}
