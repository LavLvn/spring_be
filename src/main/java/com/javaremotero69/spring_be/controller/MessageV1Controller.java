package com.javaremotero69.spring_be.controller;

/*
    #1
	Create a model class Message that stores a text and a controller class
	that can handle 2 HTTP requests of type GET to display certain messages.

	Orice metoda HTTP va fi preluata de o metoda java.
	Prin urmare, numarul de metode java va fi identic cu numarul de requesturi HTTP definite.

	Pentru a adauga un controller la contextul Spring, e nevoie sa marcam clasa cu @Controller.

	O aplicatie Spring de backend are scopul si capacitatea sa preia si prelucreze requesturi HTTP.
	Multimea requesturilor disponibile se numeste Contract de Specificatii (OpenAPI Specs)
 */

import com.javaremotero69.spring_be.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    automat domeniul este cel local

    by default accesarea unui site de orice fel se face pe baza unui request de GET
 */

@Controller // https://localhost:8080
public class MessageV1Controller {

    /*
        @RequestMapping(method = RequestMethod.GET, path = "/api/v1/hi")
            - @RequestMapping => este o anotatie Spring care ne permite sa caracterizam requestul HTTP
            dupa 2 argumente principale (type, resource path)
            - method = RequestMethod.GET => type-ul requestului HTTP
            - path = "/api/v1/hi" => resource path-ul este partea din URL specifica requestului in cauza

        URL = Uniform Resource Locator

        Exemplu: https://www.airbnb.com/rooms/1131087648837536437?adults=1&category_tag=Tag%3A8851
            - protocolul de internet: https
            - domeniu: www.airbnb.com
            - resource path: /rooms/1131087648837536437?adults=1&category_tag=Tag%3A8851 (mecanism de filtrare al resurselor
            in functie de requestul HTTP dorit)

        Requesturile HTTP sunt unice la nivel de pereche (method, path).
        Pot exista 2 requesturi:
            - cu acelasi path, dar method diferit
            - cu acelasi mthod, dar path diferit

        ResponseEntity: este un wrapper care preia o informatie Java (obiect, variabila, constanta, etc) si o imbraca cu
        caracteristicile necesare sa poata fi intoarsa ca raspuns.

        Functioneaza ca un stream builder, in sensul ca setterele se acceseaza pe obiectul curent.
        Cel mai important aspect este sa pastrati corelatia corecta intre tipul de date al body-ului si tipul de date al lui Response Entity.

        ResponseEntity ne intoarce ca raspuns o pagina HTML cu content type "text/html" DACA RASPUNSUL E DE TIPUL STRING (primitiv).
        Adica, preia informatia de pe body, si o adauga in body-ul unei pagini HTML statice.

        Daca tipul de date este o clasa de obiect, atunci content type-ul va fi "application/json" si raspunsul va fi un obiect JSON.
        Un obiect JSON are o structura similara cu cea a map-ului, unde cheia este atributul clasei de obiect, iar valoarea e ceea ce
        vine pe constructor.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/hi")    // https://localhost:8080/api/v1/hi - GET -> "hi"
    public ResponseEntity<String> getHi() {
        return ResponseEntity
                .ok()           // seteaza status codeul 200 OK daca requestul e accesat corect
                .body("hi");    // seteaza response body ul ca fiind un String "hi"
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/message")
    public ResponseEntity<Message> getMessage() {
        return ResponseEntity
                .ok()
                .body(new Message("My first message through a GET request!!"));
        // s-a initiat procesul de serializare/deserializare
    }
}
