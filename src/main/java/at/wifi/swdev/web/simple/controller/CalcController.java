package at.wifi.swdev.web.simple.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcController {
  
  @GetMapping("/tabelle")
  public String generiereTabelle(Model model) {
    List<Long> zahlen = new ArrayList<>();
    long zahl = 1;
    for (int i = 0; i <= 32; i++) {
      System.out.println("zahl " + zahl);
      zahlen.add(zahl);
      zahl *= 2;
    }
    model.addAttribute("zahlen", zahlen);
    return "tabelle"; // templates/tabelle.html
  }
}
