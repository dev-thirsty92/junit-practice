package com.junitpractice.chapter02.assumption;

class TestEnvironment {
    private JavaSpecification javaSpecification;
    private OperationSystem operationSystem;

    public TestEnvironment(JavaSpecification javaSpecification, OperationSystem operationSystem) {
        this.javaSpecification = javaSpecification;
        this.operationSystem = operationSystem;
    }

    public boolean isWindow() {
        System.out.println(this.operationSystem.getOsName());
        return this.operationSystem.getOsName().toLowerCase().contains("windows");
    }


    public String getJavaVersion() {
        System.out.println(this.javaSpecification.getJavaVersion());
        return this.javaSpecification.getJavaVersion();
    }

    public boolean isAmd64Architecture() {
        System.out.println(this.operationSystem.getArch());
        return this.operationSystem.getArch().toLowerCase().contains("amd64");
    }
}
