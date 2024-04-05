package org.experis.javawishlist;

import java.util.Objects;

public class Gift implements Comparable<Gift> {
    private String name;

    // constructor


    public Gift(String name) {
        this.name = name;
    }

    // getter


    public String getName() {
        return name;
    }

    // setter


    public void setName(String name) {
        this.name = name;
    }

    // to string

    @Override
    public String toString() {
        return "Gift{" + "name='" + name + '\'' + '}';
    }


    // equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gift gift = (Gift) o;
        return Objects.equals(getName(), gift.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }


    // compare

    @Override
    public int compareTo(Gift o) {
        return this.getName().compareTo(o.getName());
    }
}
