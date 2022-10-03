package com.example.eventogram.Repository;


import com.example.eventogram.Models.EventModel;

import java.util.ArrayList;

public class EventsRepo {
    private static EventsRepo eventsRepo;
    private  ArrayList<EventModel> eventModelList = new ArrayList<>();

    public EventsRepo() {
        eventModelList.add(new EventModel("21", "AUG", "Fireworks", "london", "591", "https://images.unsplash.com/photo-1533230408708-8f9f91d1235a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1094&q=80"));
        eventModelList.add(new EventModel("15", "FEB", "concert", "new york", "201", "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"));
        eventModelList.add(new EventModel("05", "APR", "beach party", "boston", "897", "https://images.unsplash.com/photo-1609234252033-ea4913666d25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YmVhY2hwYXJ0eXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"));
        eventModelList.add(new EventModel("24", "JAN", "music & dance", "banglore", "152", "https://images.unsplash.com/photo-1516450360452-9312f5e86fc7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"));
        eventModelList.add(new EventModel("21", "AUG", "Fireworks", "london", "591", "https://images.unsplash.com/photo-1533230408708-8f9f91d1235a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1094&q=80"));
        eventModelList.add(new EventModel("15", "FEB", "concert", "new york", "201", "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"));
        eventModelList.add(new EventModel("05", "APR", "beach party", "boston", "897", "https://images.unsplash.com/photo-1609234252033-ea4913666d25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YmVhY2hwYXJ0eXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"));
        eventModelList.add(new EventModel("24", "JAN", "music & dance", "banglore", "152", "https://images.unsplash.com/photo-1516450360452-9312f5e86fc7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"));


    }
    public static EventsRepo getEventsRepo(){
        if(eventsRepo == null){
            eventsRepo = new EventsRepo();
        }
        return eventsRepo;
    }

    public ArrayList<EventModel> getEventModelList() {
        return eventModelList;
    }
}
