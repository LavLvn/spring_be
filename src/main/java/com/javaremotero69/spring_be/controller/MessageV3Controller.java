package com.javaremotero69.spring_be.controller;

import com.javaremotero69.spring_be.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
        https://www.airbnb.com/rooms/1126323793761779132?adults=1

        Resource path-ul: /rooms/1126323793761779132?adults=1
        Exista 2 tipuri de caracterizate a resource path-ului:
            - Path Variables : este un identificator dinamic -> 1126323793761779132
            - Query Parameters : ?adults=1
 */

@Controller
public class MessageV3Controller {

    /*
        Resource path-ul => path = "/api/v3/message/{id}
            category path: /api/v3/message  - HARDCODAT (avem o constanta String neschimbata)
            path variable: /{id}            - DINAMIC (generalizam folosind un obiect Integer id)
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v3/message/{id}")
    public Message getMessageById(@PathVariable(name = "id") final Integer id) {
        return new Message("Hello world " + id);
    }
}
