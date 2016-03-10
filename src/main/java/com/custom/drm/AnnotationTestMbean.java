package com.custom.drm;

import org.springframework.jmx.export.annotation.*;

/**
 * Created by admin on 2015/12/30.
 */

@ManagedResource(objectName = "bean:name=lionbuleTest",
        description = "My Managed Bean",log = true,logFile = "Customapp-Drm.log")
public class AnnotationTestMbean {
    private String name;
    private int age;

    @ManagedAttribute()
    public String getName() {
        return name;
    }

    @ManagedAttribute(description = "The Name Attribute")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManagedOperation(description = "Add two numbers")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "x", description = "The first number"),
            @ManagedOperationParameter(name = "y", description = "The second number")
    })
    public int add_1(int x, int y) {
        return x + y;
    }

    public int add_2(int x, int y) {
        return x + y;
    }

    public void dontExposeMe() {
        throw new RuntimeException();
    }
}
