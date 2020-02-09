package com.java10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Smoothie {
    public static String ingredients(String order) {
        System.out.println("Order :" + order);
        return new Smoothie().processOrderAndGetIngredients(order);
    }

    private String processOrderAndGetIngredients(String order) {
        if(order!=null) {
            String[] orderArray = order.split(",");
            if (orderArray.length > 0) {
                String orderName = orderArray[0];
                List<String> restricted = new ArrayList<>();
                List<String> added = new ArrayList<>();
                for (int i = 1; i < orderArray.length; i++) {
                    if (orderArray[i].startsWith("-")) {
                        restricted.add(orderArray[i].substring(1));
                    } else {
                        throw new IllegalArgumentException("Invalid order placed");
                    }
                }

                FunctionalSmoothy smoothy = new SmoothyFactory().getSmoothy(orderName);
                return smoothy.getIngredients(added, restricted);
            }

        }

        throw new IllegalArgumentException("Invalid order placed");
    }

    interface FunctionalSmoothy {

        String getIngredients(List<String> added, List<String> restricted);
    }

    class FunctionalSmoothyImpl implements FunctionalSmoothy {
        private String name;
        private List<String> ingredents;

        public List<String> getIngredents() {
            return ingredents;
        }

        public FunctionalSmoothyImpl(String menu, List<String> ingredents) {
            this.name = menu;
            this.ingredents = ingredents;
        }


        @Override
        public String getIngredients(List<String> added, List<String> restricted) {
            List<String> diff = getIngredents().stream()
                    .filter(e -> !restricted.contains(e))
                    .sorted()
                    .collect (Collectors.toList());
            return diff.stream()
                    .collect(Collectors.joining(","));

        }
    }

    class SmoothyFactory {
        public FunctionalSmoothy getSmoothy(String smoothyName) {
            if ("Classic".equals(smoothyName)) {
                return new FunctionalSmoothyImpl("Classic",
                        Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
            } else if ("Freezie".equals(smoothyName)) {
                return new FunctionalSmoothyImpl("Freezie",
                        Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));

            } else if ("Greenie".equals(smoothyName)) {
                return new FunctionalSmoothyImpl("Greenie",
                        Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));

            } else if ("Just Desserts".equals(smoothyName)) {
                return new FunctionalSmoothyImpl("Just Desserts",
                        Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry"));

            } else {
                throw new IllegalArgumentException("Invalid order placed");
            }
        }
    }

}

