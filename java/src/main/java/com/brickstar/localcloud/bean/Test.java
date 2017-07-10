package com.brickstar.localcloud.bean;

/**
 * Created by bricks on 17-6-27.
 */
public class Test<T> {
    private String id;
    private String name;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
