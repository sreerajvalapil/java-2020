package com.java8;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main (String args[]) {
        new SupplierDemo().myFunction();
    }

    public void myFunction() {
       process(() -> new Student("sree","sree@sree.com"));

    }

    public Student process(Supplier<Student> supplier) {
        Student student = supplier.get();
        student.setPhone(1213131);
        return student;

    }

    class Student {
        private String name;
        private String email;
        private Integer phone;

        public void setPhone(Integer phone) {
            this.phone = phone;
        }

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }

    }
}
