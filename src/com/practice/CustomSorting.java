package com.practice;

import java.util.*;

public class CustomSorting {

    public enum RQ_CODE{
       Q("A"),T("T"),P("P"),A("A");
        private String label;

        RQ_CODE(String label) { this.label = label; }

        @Override public String toString() { return label; }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList(Arrays.asList("A","P","T","Q"));
        Collections.sort(list,((o1, o2) -> {
            List<String> l = Arrays.asList("Q","T","P","A");
            return l.indexOf(o1) - l.indexOf(o2) ;
        }));
       // System.out.println("result is ... :" +list);

        new CustomSorting().test() ;


    }

    private void test() {
       List<Person> myList = new ArrayList<>(Arrays.asList(
               new Person("sree","physics","Q"),
               new Person("mani","chemistry","A"),
               new Person("paappu","physics","Q"),
               new Person("Aru","physics","A")));
       Collections.sort(myList, Comparator.comparing(Person::getClassName)
       .thenComparing(Comparator.comparing(Person::getGradeOrder)
       .thenComparing(Comparator.comparing(Person::getName).reversed())));
        System.out.println("The result is ...  :" + myList);
    }

    class Person {
        private String name ;
        private String className;
        private String gradeName;
        private List<String> gradeInOrder = Arrays.asList("Q","T","P","A");

        public Person(String name, String className, String gradeName) {
            this.name = name;
            this.className = className;
            this.gradeName = gradeName;
        }

        public String getName() {
            return name;
        }

        public String getClassName() {
            return className;
        }

        public String getGradeName() {
            return gradeName;
        }
        public Integer getGradeOrder() {
            return this.gradeInOrder.indexOf(this.getGradeName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", className='" + className + '\'' +
                    ", gradeName='" + gradeName + '\'' +
                    '}';
        }
    }
}
