package com.netflix.simianarmy.aws.janitor;

import java.util.Date;

public class InstanceInfo {

    private String instance;
    private String owner;
    private Date lastDetachTime;

    public InstanceInfo(String instance, String owner, Date lastDetachTime) {
        this.instance = instance;
        this.owner = owner;
        this.lastDetachTime = lastDetachTime;
    }

    public String getInstance() {
        return instance;
    }

    public String getOwner() {
        return owner;
    }

    public Date getLastDetachTime() {
        return lastDetachTime;
    }
}

