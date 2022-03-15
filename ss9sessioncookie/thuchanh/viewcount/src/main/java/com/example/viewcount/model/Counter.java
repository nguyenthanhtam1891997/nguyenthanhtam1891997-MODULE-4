package com.example.viewcount.model;

import java.util.Objects;

public class Counter {
    private int id;

    private int count;

    public Counter() {
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return id == counter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
