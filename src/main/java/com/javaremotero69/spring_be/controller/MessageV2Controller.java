package com.javaremotero69.spring_be.controller;

/*
    Create a new controller based on #1 and adjust the
    endpoints to use Response Body class.
 */

import com.javaremotero69.spring_be.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Diferenta intre ResponseBody si ResponseEntity este accesul la metadate.
    ResponseBody propune o varianta template in functie de request type si response.
    In timp ce ResponseEntity ofera controlul total programatorului.
 */

@Controller
public class MessageV2Controller {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v2/hi")
    public String getHi() {
        return "Hi";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v2/message")
    public Message getMessage() {
        return new Message("My first message through a GET request!!");
    }
}
