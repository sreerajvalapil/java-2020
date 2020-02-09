package com.java10.capgemini;

import java.util.*;
import java.util.Scanner;

public class BAPCSpyCarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Result> finalResults = new ArrayList<>();
        while (sc.hasNextLine()) {
            int testCount = Integer.parseInt(sc.nextLine());
            for (int i = 1; i <= testCount; i++) {
                String input = sc.nextLine();
                String[] inputArray = input.split(" ");

                int numberOfCar = Integer.parseInt(inputArray[0]);
                Map<String, BapcCar> carNameCarMap = new HashMap<>();
                for (int j = 1; j <= numberOfCar; j++) {
                    String carDataInput = sc.nextLine();
                    String[] carDataInputArray = carDataInput.split(" ");
                    if (carDataInputArray.length == 4) {
                        BapcCar bapcCar = new BapcCar(carDataInputArray[0],
                                Double.parseDouble(carDataInputArray[1]),
                                Double.parseDouble(carDataInputArray[2]),
                                Double.parseDouble(carDataInputArray[3]));
                        carNameCarMap.put(carDataInputArray[0], bapcCar);
                    }
                }


                int numberOfEvent = Integer.parseInt(inputArray[1]);
                Map<String, List<BapcEvent>> spyNameEventMap = new HashMap<>();
                for (int k = 1; k <= numberOfEvent; k++) {
                    String eventDataInput = sc.nextLine();
                    String[] eventDataInputArray = eventDataInput.split(" ");
                    if (eventDataInputArray.length == 4) {
                        String eventType = eventDataInputArray[2];
                        EventType eType = null;
                        if ("p".equals(eventType)) {
                            eType = new EventPickUp(eventDataInputArray[3]);
                        } else if ("r".equals(eventType)) {
                            eType = new EventReturn(Integer.parseInt(eventDataInputArray[3]));
                        } else if ("a".equals(eventType)) {
                            eType = new EventAccident(Integer.parseInt(eventDataInputArray[3]));
                        }
                        BapcEvent bapcEvent = new BapcEvent(Integer.parseInt(eventDataInputArray[0]),
                                eventDataInputArray[1], eType);
                        List<BapcEvent> spyEventList = new ArrayList<>();
                        if (spyNameEventMap.get(eventDataInputArray[1]) == null) {
                            spyEventList = new ArrayList<BapcEvent>();
                        } else {
                            spyEventList = spyNameEventMap.get(eventDataInputArray[1]);
                        }
                        spyEventList.add(bapcEvent);
                        spyNameEventMap.put(eventDataInputArray[1], spyEventList);
                    }
                }
                List<Result> resultForTestCase = computeSpyCost(carNameCarMap, spyNameEventMap);
                resultForTestCase.sort(Comparator.comparing(Result::getSpyName));
                finalResults.addAll(resultForTestCase);
            }
        }
        finalResults.stream().forEach
                (result -> {
                    System.out.println(result.getSpyName() + " " + result.getTotalCostString());
                });
    }

    private static List<Result> computeSpyCost(Map<String, BapcCar> carNameCarMap,
                                               Map<String, List<BapcEvent>> spyNameEventMap) {
        List<Result> resultsArray = new ArrayList<>();
        for (Map.Entry<String, List<BapcEvent>> entry : spyNameEventMap.entrySet()) {
            String spyName = entry.getKey();
            List<BapcEvent> spyEventList = entry.getValue();
            boolean isPickedUp = false;
            boolean isReturned = false;
            String pickedCarName = "";
            Result result = new Result();
            if (inconsistent(spyEventList)) {
                result.setSpyName(spyName);
                result.setTotalCost(0);
                result.setTotalCostString("INCONSISTENT");
                continue;
            }

            List<BAPCSpyCarTest.Interval> intervalList = new ArrayList<>();

            for (BapcEvent event : spyEventList) {
                if (event.eventType.isPickedEvent()) {
                    BAPCSpyCarTest.Interval interval = new BAPCSpyCarTest.Interval();
                    interval.setStart(event.getTimeOfEvent());
                    intervalList.add(interval);

                    if (isPickedUp && !isReturned) {
                        result.setSpyName(spyName);
                        result.setTotalCost(0);
                        result.setTotalCostString("INCONSISTENT");
                        break;
                    } else {
                        isPickedUp = true;
                        isReturned = false;
                        pickedCarName = event.eventType.getPickedCarName();
                        result.setSpyName(spyName);
                        result.setTotalCost(result.getTotalCost()
                                + carNameCarMap.get(pickedCarName).getPickUpCost());
                    }
                } else if (event.eventType.isReturnEvent()) {
                    if (!intervalList.isEmpty()) {
                        BAPCSpyCarTest.Interval interval = intervalList.get(intervalList.size() - 1);
                        if (interval.getEnd() == -1)
                            interval.setEnd(event.getTimeOfEvent());
                        else {
                            BAPCSpyCarTest.Interval interval1 = new BAPCSpyCarTest.Interval();
                            interval1.setEnd(event.getTimeOfEvent());
                            intervalList.add(interval1);
                        }
                    } else {
                        BAPCSpyCarTest.Interval interval = new BAPCSpyCarTest.Interval();
                        interval.setEnd(event.getTimeOfEvent());
                        intervalList.add(interval);

                    }
                    if (isPickedUp) {
                        double currentCost = result.getTotalCost() +
                                event.eventType.getDistanceInKM() * carNameCarMap.get(pickedCarName).getKmPrice();
                        result.setTotalCost(currentCost);
                        isReturned = true;
                        isPickedUp = false;
                    } else {
                        result.setSpyName(spyName);
                        result.setTotalCost(0);
                        result.setTotalCostString("INCONSISTENT");
                        break;
                    }

                } else if (event.eventType.isAccidentEvent()) {
                    if (isReturned) {
                        result.setSpyName(spyName);
                        result.setTotalCost(0);
                        result.setTotalCostString("INCONSISTENT");
                        break;
                    } else if (isPickedUp) {
                        double currentCost = result.getTotalCost() +
                                (event.eventType.getAccidentSeverityPercentage() *
                                        (carNameCarMap.get(pickedCarName).getCatalogePrice() / 100.0f));
                        result.setTotalCost(currentCost);
                    }
                }
            }
            // intervalList.stream().forEach(obj->{System.out.println(obj.toString());});
            if (intervalList.stream().filter(obj -> obj.getStart() == -1 || obj.getEnd() == -1).count() > 0) {
                result.setSpyName(spyName);
                result.setTotalCost(0);
                result.setTotalCostString("INCONSISTENT");
                continue;
            }
                return true;
            intervalList.sort(Comparator.comparing(BAPCSpyCarTest.Interval::getStart));


            if (isOverlap(intervalList.toArray(new Interval[intervalList.size()]), intervalList.size())) {
                return true;
            }


            if (!isReturned) {
                result.setSpyName(spyName);
                result.setTotalCost(0);
                result.setTotalCostString("INCONSISTENT");
            }
            resultsArray.add(result);

        }
        return resultsArray;
    }

    private static boolean inconsistent(List<BapcEvent> spyEventList) {
        List<BAPCSpyCarTest.Interval> intervalList = new ArrayList<>();


        for (BAPCSpyCarTest.BapcEvent event : spyEventList) {
            if (event.eventType.isPickedEvent()) {
                BAPCSpyCarTest.Interval interval = new BAPCSpyCarTest.Interval();
                interval.setStart(event.getTimeOfEvent());
                intervalList.add(interval);
            }
            if (event.eventType.isReturnEvent()) {
                if (!intervalList.isEmpty()) {
                    BAPCSpyCarTest.Interval interval = intervalList.get(intervalList.size() - 1);
                    if (interval.getEnd() == -1)
                        interval.setEnd(event.getTimeOfEvent());
                    else {
                        BAPCSpyCarTest.Interval interval1 = new BAPCSpyCarTest.Interval();
                        interval1.setEnd(event.getTimeOfEvent());
                        intervalList.add(interval1);
                    }
                } else {
                    BAPCSpyCarTest.Interval interval = new BAPCSpyCarTest.Interval();
                    interval.setEnd(event.getTimeOfEvent());
                    intervalList.add(interval);

                }
            }
        }
        // intervalList.stream().forEach(obj->{System.out.println(obj.toString());});
        if (intervalList.stream().filter(obj -> obj.getStart() == -1 || obj.getEnd() == -1).count() > 0)
            return true;
        intervalList.sort(Comparator.comparing(BAPCSpyCarTest.Interval::getStart));


        if (isOverlap(intervalList.toArray(new Interval[intervalList.size()]), intervalList.size())) {
            return true;
        }

        return false;
    }

    private static class Interval {
        private int start = -1;
        private int end = -1;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static class Result {
        private String spyName;
        private double totalCost = 0;
        private String totalCostString = "NA";

        public Result() {
        }

        public Result(String spyName, double totalCost) {
            this.spyName = spyName;
            this.totalCost = totalCost;
        }

        public String getSpyName() {
            return spyName;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCostString(String totalCostString) {
            this.totalCostString = totalCostString;
        }

        public String getTotalCostString() {
            if (!"INCONSISTENT".equals(totalCostString)) {
                return String.valueOf(Math.round(totalCost));
            }
            return totalCostString;
        }

        public void setSpyName(String spyName) {
            this.spyName = spyName;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }
    }

    private static class BapcCar {
        private String carName;
        private double catalogePrice;
        private double pickUpCost;
        private double kmPrice;

        public BapcCar(String carName, double catalogePrice, double pickUpCost, double kmPrice) {
            this.carName = carName;
            this.catalogePrice = catalogePrice;
            this.pickUpCost = pickUpCost;
            this.kmPrice = kmPrice;
        }

        public String getCarName() {
            return carName;
        }

        public double getCatalogePrice() {
            return catalogePrice;
        }

        public double getPickUpCost() {
            return pickUpCost;
        }

        public double getKmPrice() {
            return kmPrice;
        }
    }

    private static class BapcEvent {
        private int timeOfEvent;
        private String spyName;
        private EventType eventType;

        public BapcEvent(int timeOfEvent, String spyName, EventType eventType) {
            this.timeOfEvent = timeOfEvent;
            this.spyName = spyName;
            this.eventType = eventType;
        }

        public int getTimeOfEvent() {
            return timeOfEvent;
        }

        public String getSpyName() {
            return spyName;
        }

        public EventType getEventType() {
            return eventType;
        }
    }

    interface EventType {
        default boolean isPickedEvent() {
            return false;
        }

        default boolean isReturnEvent() {
            return false;
        }

        default boolean isAccidentEvent() {
            return false;
        }

        default String getPickedCarName() {
            return "";
        }

        default double getDistanceInKM() {
            return 0;
        }

        default double getAccidentSeverityPercentage() {
            return 0;
        }


    }

    private static class EventPickUp implements EventType {
        private String eventTypeName = "p";
        private String pickedCarName;

        public EventPickUp(String pickedCarName) {
            this.pickedCarName = pickedCarName;
        }

        @Override
        public boolean isPickedEvent() {
            return true;
        }

        @Override
        public String getPickedCarName() {
            return this.pickedCarName;
        }
    }

    private static class EventReturn implements EventType {
        private String eventTypeName = "r";
        private double distanceInKM;

        public EventReturn(int distanceInKM) {
            this.distanceInKM = distanceInKM;
        }

        @Override
        public boolean isReturnEvent() {
            return true;
        }

        @Override
        public double getDistanceInKM() {
            return this.distanceInKM;
        }
    }

    private static class EventAccident implements EventType {
        private String eventTypeName = "a";
        private double accidentSeverityPercentage;

        public EventAccident(int accidentSeverityPercentage) {
            this.accidentSeverityPercentage = accidentSeverityPercentage;
        }

        @Override
        public boolean isAccidentEvent() {
            return true;
        }

        @Override
        public double getAccidentSeverityPercentage() {
            return this.accidentSeverityPercentage;
        }

    }

    private static boolean isOverlap(BAPCSpyCarTest.Interval[] arr, int n) {
        for (int i = 1; i < n; i++)
            if (arr[i].end <= arr[i - 1].end)
                return true;
        return false;
    }
}