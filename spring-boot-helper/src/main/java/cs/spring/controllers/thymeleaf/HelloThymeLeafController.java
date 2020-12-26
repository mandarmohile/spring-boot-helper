package cs.spring.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloThymeLeafController {

	@RequestMapping("/thymeleaf")
    public String thymeleaf() {
        return "hello";
    }
}

/**
https://stackoverflow.com/questions/47134189/what-is-difference-between-contextrefreshedevent-contextstartedevent-contextst?rq=1
https://springframework.guru/running-code-on-spring-boot-startup/
https://www.baeldung.com/spring-context-events
https://www.baeldung.com/spring-events
https://www.javacodegeeks.com/2017/10/asynchrouns-transactional-event-listeners-spring.html
*/
