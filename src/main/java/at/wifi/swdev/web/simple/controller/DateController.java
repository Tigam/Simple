package at.wifi.swdev.web.simple.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller, welcher die Anfragen vom Client übernimmt.
 * Danach wird, wenn vorhanden, das Modell befüllt. Der Rückgabewert 
 * ist hierbei der Seitenname ohne Erweiterung .html im Verzeichnis
 * templates/.
 * Url:
 * <ul>
 * <li>http://localhost:8080/date</li>
 * </ul>
 * 
 * Beispiel:
 * Client fragt an: GET http://localhost:8080/date
 * WebApplikation simple erkennt die Anfrage auf /date und wählt diesen
 * Controller aus. Aufgrund des GetMappings "date" wird die Methode showDateTime 
 * aufgerufen und das Modell automatisch erstellt.
 * In der Methode date wird das Model mit dem Schlüssel now und dem Wert
 * der Variable now befüllt.
 * Danach wird an die View (Seite) date aufgerufen (im Verzeichnis templates).
 * In dieser Seite wird erkannt, dass es sich um eine Thymeleaf Template Seite
 * handelt und mit dem Attribut th:text wird mit auf das Model zugegriffen und 
 * die Variable mit dem Platzhalter ${now} ausgelesen.
 * 
 */
@Controller
public class DateController {
  
  
  @GetMapping("/date")
  public String showDateTime(Model model) {
    LocalDateTime now = LocalDateTime.now();
    // Ausgabe im Server Log (Netbeans Output) und nicht am Client.
    System.out.println("Datum/Uhrzeit " + now);
    model.addAttribute("now", now);
    return "date"; // templates/date.html Seite als View
  }
}
