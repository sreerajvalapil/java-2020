package com.benify;

import java.util.*;
import java.util.stream.Collectors;

public class Test {



    public static void main(String[] args) {
        String str = "-a11111";
      //  System.out.println("My program .... " +str.matches("-?\\d+"));

      List<String> result = getEventsOrder("abc","cba",
                Arrays.asList("mo sa 45+2 Y","a 13 G"),Arrays.asList("d 23 S f aa","z 46 G"));
        System.out.println("Final is .. : " + result.toString());
    }

    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        return new Test().findEventsOrder(team1,team2,events1,events2);
    }

    /*
     * Complete the 'getEventsOrder' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING team1
     *  2. STRING team2
     *  3. STRING_ARRAY events1
     *  4. STRING_ARRAY events2
     */

    public  List<String> findEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        // Write your code here
        List<Event> eventList = new ArrayList<>() ;
        for (String event : events1) {
            eventList.add(convertToEvent(team1,event));
        }
        for (String event : events2) {
            eventList.add(convertToEvent(team2,event));
        }
        System.out.println("Before eventList is : " + eventList.toString());
        Collections.sort(eventList, Comparator.comparing(Event::getTime)
                .thenComparing((o1, o2) -> {
                    List<String> l = Arrays.asList("A","D","T","S") ;
                    return l.indexOf(o1.getEventName()) - l.indexOf(o2.getEventName());
                })
                .thenComparing(Event::getTeamName)
                .thenComparing(Event::getEmployeeName));
        System.out.println("After eventList is : " + eventList.toString());

        // Result
        List <String> result = eventList.stream()
                .map(Event::toString).collect(Collectors.toList());
        return result ;
    }

    /*
     * The function converting a String to Event Object . It uses smart logic to
     *  figure out what employee name and second employee name
     * The function accepts following parameters:
     *  1. STRING teamName
     *  2. STRING eventStr
     */


    private  Event convertToEvent(String teamName,String eventStr) {
        String[] eventArray = eventStr.split(" ");

        StringBuilder employeeName = new StringBuilder(eventArray[0] .trim());
        Integer eventTime = 0 ;
        String timeStr = "" ;
        int timeIndex = 0 ;
        for(int i = 1 ; i< eventArray.length ; i ++ ) {
            if(eventArray[i].contains("+")) {
                eventTime = Integer.parseInt(eventArray[i].substring(0,eventArray[i].indexOf("+")));
                timeIndex = i ;
                timeStr = eventArray[i];
                break;
            } else if(eventArray[i].matches("-?\\d+")) {
                eventTime = Integer.parseInt(eventArray[i]);
                timeIndex = i ;
                timeStr = eventArray[i];
                break;
            } else {
                employeeName.append(" ").append(eventArray[i]) ;
            }
        }
        String eventName = eventArray[timeIndex +1] ;
        Event event = new Event(teamName, employeeName.toString(),
                eventTime,timeStr, eventName);

        if(eventArray.length>timeIndex +2) {
            StringBuilder secondEmployeeName = new StringBuilder("");
            for(int i = timeIndex +2 ; i< eventArray.length ; i ++ ) {
                secondEmployeeName.append(eventArray[i]).append(" ");
            }
            event.setSecondEmployeeName(secondEmployeeName.toString().trim()) ;
        }
        return event;
    }

    /*
     *  Inner class represent the Event Object , The class uses for sorting the different event in the order
     */


    class Event {
        private String teamName;
        private String employeeName;
        private Integer time;
        private String timeStr;
        private String eventName;
        private String secondEmployeeName="";

        public Event(String teamName, String employeeName, Integer time, String timeStr, String eventName) {
            this.teamName = teamName;
            this.employeeName = employeeName;
            this.time = time;
            this.timeStr = timeStr ;
            this.eventName = eventName;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getSecondEmployeeName() {
            return secondEmployeeName;
        }

        public void setSecondEmployeeName(String secondEmployeeName) {
            this.secondEmployeeName = secondEmployeeName;
        }

        @Override
        public String toString() {
           return  (getTeamName() +" " + getEmployeeName() + " "
                    + getTimeStr() + " " + getEventName() + " " +getSecondEmployeeName()).trim();

        }
    }

}
