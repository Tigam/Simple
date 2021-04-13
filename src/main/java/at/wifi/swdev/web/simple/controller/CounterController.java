package at.wifi.swdev.web.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Controller, welcher die Anfragen vom Client übernimmt.
 * Danach wird, wenn vorhanden, das Modell befüllt. Der Rückgabewert 
 * ist hierbei der Seitenname ohne Erweiterung .html im Verzeichnis
 * templates/.
 * Urls:
 * <ul>
 * <li>http://localhost:8080/start</li>
 * <li>http://localhost:8080/inc</li>
 * </ul>
 * 
 * Beispiel:
 * Client fragt an: GET http://localhost:8080/start
 * WebApplikation simple erkennt die Anfrage auf /start und wählt diesen
 * Controller aus. Aufgrund des GetMappings "start" wird die Methode start 
 * aufgerufen und das Modell automatisch erstellt.
 * In der Methode start wird das Model mit dem Schlüssel counter und dem Wert
 * der Variable counter befüllt.
 * Danach wird an die View (Seite) counter aufgerufen (im Verzeichnis templates).
 * In dieser Seite wird erkannt, dass es sich um eine Thymeleaf Template Seite
 * handelt und mit dem Attribut th:text wird mit auf das Model zugegriffen und 
 * die Variable mit dem Platzhalter ${counter} ausgelesen.
 * 
 * Mit Hilfe der Annotation SessionScope wird für jede einzelne Browser Session
 * ein eigener Speicherbereich belegt.
 */
@Controller
@SessionScope
public class CounterController {
  
  
  private int counter;
  
  @GetMapping("start")
  public String start(Model model) {
    counter = 0;
    model.addAttribute("counter", counter);
    return "counter"; // templates/counter.html
  }
  
  @GetMapping("inc")
  public String inc(Model model) {
    counter++;
    model.addAttribute("counter", counter);
    return "counter";
  }
  
  
}
