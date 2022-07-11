package ru.job4j.stream;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String name;
    private final int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "Student{name='"
                + name + "'"
                + ", scope="
                + scope + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getScope() == student.getScope() && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScope());
    }

    @Override
    public int compareTo(Student o) {
        return o.getScope() - getScope();
    }
}
