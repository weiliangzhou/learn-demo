package com.zwl.learn.observer.event;

import org.springframework.context.ApplicationEvent;

public class ErsxMessage extends ApplicationEvent {
    private String name;
    private Integer age;


    public ErsxMessage(Object source) {
        super(source);
    }

    public ErsxMessage(Object source, String name, Integer age) {
        super(source);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        {
            return "name:" + name + ",age:" + age;
        }
    }
}
