package com.junitpractice.chapter02.assumption;

public class OperationSystem {
    private String osName;
    private String arch;

    public OperationSystem(String osName, String arch) {
        this.osName = osName;
        this.arch = arch;
    }

    public String getOsName() {
        return osName;
    }

    public String getArch() {
        return arch;
    }
}
