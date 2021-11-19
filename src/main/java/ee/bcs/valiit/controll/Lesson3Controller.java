package ee.bcs.valiit.controll;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    @GetMapping("lesson3/factorial")
    public int factorial(@RequestParam("a") int a) {
        return Lesson3.factorial(a);
    }

    @GetMapping("lesson3/reverseString")
    public String reverseString(@RequestParam("a") String a) {
        return Lesson3.reverseString(a);
    }

    @GetMapping("lesson3/isPrime")
    public boolean isPrime(@RequestParam("a") int a) {
        return Lesson3.isPrime(a);
    }

    @GetMapping("lesson3/sort")
    public int [] sort(@RequestParam("a") int[] a) {
        return Lesson3.sort(a);
    }

    @GetMapping("lesson3/evenFibonacci")
    public int evenFibonacci(@RequestParam("a") int a) {
        return Lesson3.evenFibonacci(a);
    }

    @GetMapping("lesson3/morseCode")
    public String morseCode(@RequestParam("a") String a) {
        return Lesson3.morseCode(a);
    }
}
