package at.wifi.swdev.web.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Controller, welcher die Anfragen vom Client übernimmt.
 * Danach wird, wenn vorhanden, das Modell befüllt. Der Rückgabewert 
 * ist hierbei der Seitenname ohne Erweiterung .html im Verzeichnis
 * templates/.
 * Urls:
 * <ul>
 * <li>http://localhost:8080/eingabe</li>
 * <li>http://localhost:8080/ausgabe</li>
 * </ul>
 * 
 * Beispiel:
 * Client fragt an: GET http://localhost:8080/eingabe
 * WebApplikation simple erkennt die Anfrage auf /eingabe und wählt diesen
 * Controller aus. Aufgrund des GetMappings "eingabe" wird die Methode eingabe 
 * aufgerufen und das Modell automatisch erstellt.
 * In der Seite (View) eingabe wird das Formular vom User befüllt und mittels
 * POST an die Seite ausgabe gesendet.
 * In der Methode ausgabe wird das Model mit dem Schlüssel ausgabeName und dem Wert
 * der Variable ausgabeText befüllt.
 * Danach wird an die View (Seite) ausgabe aufgerufen (im Verzeichnis templates).
 * In dieser Seite wird erkannt, dass es sich um eine Thymeleaf Template Seite
 * handelt und mit dem Attribut th:text wird mit auf das Model zugegriffen und 
 * die Variable mit dem Platzhalter ${ausgabeName} ausgelesen und ausgegeben.
 * 
 */
@Controller
@SessionScope
public class EchoController {
  
  /**
   * Die Seite mit dem Formular zur Eingabe des Namens wird angezeigt.
   * @return Der Seitenname ohne Erweiterung im Verzeichnis templates.
   */
  @GetMapping("eingabe")
  public String eingabe() {
    return "eingabe"; // templates/eingabe.html
  }
  
  /**
   * Hier wird nun eine POST Anfrage bearbeitet. Eine GET Anfrage liefert
   * einen Fehler.
   * Über die Seite eingabe wird der Parameter "name" aus dem Formular übernommen
   * und weiterverarbeitet.
   * @param model Das erstelle Model für den Controller
   * @param name Der übergebene Parameter aus dem Formular.
   * @return Der Seitenname ohne Erweiterung im Verzeichnis templates.
   */
  @PostMapping("ausgabe")
  public String ausgabe(Model model, @RequestParam("name") String name) {
    String ausgabeText = "Hallo " + name + "!";
    model.addAttribute("ausgabeName", ausgabeText);
    return "ausgabe"; // templates/ausgabe.html
  }
}
