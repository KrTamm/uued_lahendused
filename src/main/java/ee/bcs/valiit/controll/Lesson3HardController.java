package ee.bcs.valiit.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {

    Random random = new Random();
    int i = random.nextInt(100);
    int guesscount = 0;

    //localhost:8080/lesson3Hard?a=50
    @GetMapping("lesson3Hard")
    public String lesson3HardControl(@RequestParam("a") int a) {
        guesscount++;
        if (a == i) {
            return "Tubli, õige number oli " + i + ". Said hakkama " + guesscount + " katsega.";
        } else if (a < i) {
            return "Sisesta suurem number.";
        } else {
            return "Sisesta väiksem number.";
        }
    }
}