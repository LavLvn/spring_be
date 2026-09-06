package com.javaremotero69.spring_be.controller;

import com.javaremotero69.spring_be.model.Message;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
    Create a new MessageController that handles 4 requests:
    • C: to store new messages (POST, INSERT)
    • R: to display all messages (GET, SELECT)
    • U: to update old messages by index (PUT/PATCH, UPDATE)
    • D: to delete a message by index (DELETE, DELETE)

    CRUD = CREATE READ UPDATE DELETE

    Alternativa de stocare a mesajelor va fi utilizarea unei structuri de date Java.

    Exista mai multe informatii de request:
        - la nivel de path:
            -- PathVariable si QueryParams
        - la nivel de body:
            -- RequestBody
 */

/*
    In situatia in care, nu va doriti sa mai aveti @ResponseBody peste tot, puteti utiliza @RestController.
    @RestController = @Controller + @ResponseBody (de pe toate metodele)

    O alta varianta de a optimiza codul, este de a utiliza anotatiile de mapping specializate.
    @<RequestMethod>Mapping = @GetMapping, @PutMapping, @PostMapping, @DeleteMapping, @PatchMapping etc...
 */

//@Controller
@RestController
@RequestMapping("/api/v4")
public class MessageV4Controller {

    private final List<Message> messages = new ArrayList<>();

    /* CREATE - POST */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST, path = "/api/v4/messages")
    @PostMapping(path = "messages")
    public void createMessage(@RequestBody final Message message) {
        this.messages.add(message);
    }

    /* READ - GET */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.GET, path = "/api/v4/messages")
    @GetMapping(path = "messages")
    public List<Message> getAllMessages() {
        return this.messages;
    }

    /* UPDATE - PUT */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.PUT, path = "/api/v4/messages/{index}")
    @PutMapping(path = "/messages/{index}")
    public void updateMessageByIndex(@RequestBody final Message message, @PathVariable final Integer index) {
        // daca existau mai multe atribute, existau 2 aternative:
            // fie actualizati cu setter fiecare atribut
            // fie creati in clasa obiect Message o metoda de actualizare a tuturor atributelor
        this.messages.get(index).setText(message.getText());
    }

    /*  DELETE - DELETE */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.DELETE, path = "/api/v4/messages/{index}")
    @DeleteMapping(path = "messages/{index}")
    public void deleteMessageByIndex(@PathVariable final Integer index) {
        this.messages.remove(index.intValue());
    }
}
