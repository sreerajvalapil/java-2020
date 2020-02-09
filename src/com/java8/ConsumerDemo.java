package com.java8;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main (String args[]) {
        new SupplierDemo().myFunction();
    }

    public void myFunction() {
        process((ss) -> {ss.phone = "052323232";} );

    }

    public void process(Consumer<Student> consumer) {
        Student s = new Student("sdd","sr@vvm.com");
        consumer.accept(s);
    }

    class Student {
        private String name;
        private String email;
        private String phone;

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
