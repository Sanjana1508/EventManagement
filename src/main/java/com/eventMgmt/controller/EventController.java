package com.eventMgmt.controller;


import com.eventMgmt.entity.Event;
import com.eventMgmt.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public String getAllEvents(Model theModel){
        List<Event> events = eventService.findAll();
        theModel.addAttribute("events",events);
        return "listEvents";
    }

   @GetMapping("/addEvent")
    public String addEvent(Model theModel){
        Event event = new Event();
        theModel.addAttribute("event",event);
        return "eventForm";
   }

   @GetMapping("/updateEvent")
    public String updateEvent(@RequestParam("eventId") int theId,Model theModel){
        Event event= eventService.findById(theId);
        theModel.addAttribute("event",event);
        return "eventForm";
   }

   @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event theEvent, Errors errors){
        if(errors!=null && errors.getErrorCount()>0)
            return "eventForm";
        eventService.save(theEvent);
        return "redirect:/events/list";
   }

   @GetMapping("/delete")
    public String deleteEvent(@RequestParam("eventId") int eventId){
        eventService.deleteById(eventId);
        return "redirect:/events/list";
   }

}
