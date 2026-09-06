package com.javaremotero69.spring_be.controller;

import com.javaremotero69.spring_be.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/*
    Inside #4 or #5’s controller, create an endpoint that handles searching
    a message by text in the attribute’s dummy list.

    Must return found or not found as status

    QueryParam = RequestParam
 */

@Controller
public class MessageV6Controller {

    // Listele create cu Arrays.asList sau List.of sunt liste constante, adica IMUTABILE
    // totodata, keyword-ul final indica faptul ca lista e constanta
    private final List<Message> messages = Arrays.asList(
            new Message("alune"),
            new Message("aluat"),
            new Message("albastru"),
            new Message("acadele"),
            new Message("catel")
    );

    @RequestMapping(method = RequestMethod.GET, path = "/api/v6/messages/search") // http://localhost:8080/api/v6/messages/search?text=value
    public ResponseEntity<List<Message>> searchMessagesByText(@RequestParam("text") final String text) {
        List<Message> foundMessages = this.messages
                .stream()
                .filter(it -> it.getText().contains(text))  // if
                .toList();

        if(foundMessages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundMessages, HttpStatus.FOUND);
        }
    }
}
