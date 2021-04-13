package at.wifi.swdev.web.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Erste Spring Boot Webanwendung mit unterschiedlichen Anwendungsfällen.
 * 
 * Weiterführende Dokumentationen
 * 
 * Spring Boot Web
 * https://spring.io/guides/gs/spring-boot/
 * https://www.tutorialspoint.com/spring_boot/index.htm
 * 
 * LinkedIn Learning Kurse (Nur die "einfachen" Einführungsteile sind relevant)
 * https://www.linkedin.com/learning/learning-spring-with-spring-boot-2/learn-rapid-development-with-spring-boot?u=48771124
 * https://www.linkedin.com/learning/spring-boot-2-0-essential-training/mvc-in-spring-boot?u=48771124
 * 
 * Thymeleaf
 * https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
 * https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
 */
@SpringBootApplication
public class SimpleApplication {

  /**
   * Haupteinsprungspunkt
   * @param args Die Kommandozeilenparameter
   */
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

}
