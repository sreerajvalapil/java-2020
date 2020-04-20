package com.java8.lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LamdaTest {
    public static void main(String[] args) {

    new LamdaTest()
            .processConsumer(h1->h1.setGrade("A"));

    new LamdaTest()
            .processSupplier(() -> { return new Horse("200",240);});
    new LamdaTest()
                .processSupplier(() ->  new Horse("200",240));

    new LamdaTest()
            .processFunction((horse -> horse.getCode()));

        new LamdaTest()
                .processFunction(Horse::getCode);

    }

    private  Horse processSupplier(Supplier<Horse> horseSupplier) {
        return horseSupplier.get();

    }

    private  Horse processConsumer(Consumer<Horse> horseConsumer) {
        Horse h1 = new Horse("100",124) ;
        horseConsumer.accept(h1);
        return h1;
    }

    private  String processFunction(Function<Horse,String> horseStringFunction) {
        Horse h1 = new Horse("100",124) ;
        return horseStringFunction.apply(h1);
    }



    private  void processFunction() {

    }

 static class Horse {

        private String code ;
        private Integer power ;
        private String grade  ;

     public Horse(String code, Integer power) {
         this.code = code;
         this.power = power;
     }

     public void setGrade(String grade) {
         this.grade = grade;
     }

     public String getCode() {
         return code;
     }

     public Integer getPower() {
         return power;
     }

     public void setCode(String code) {
         this.code = code;
     }
 }
}
