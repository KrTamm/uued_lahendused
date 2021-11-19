package ee.bcs.valiit.controll;

import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRegistry;

@RestController
public class Lesson2bController {

    @GetMapping("lesson2b/reverseArray")
    public int[] reverseArray(@RequestParam("a") int[] a) {
        return Lesson2b.reverseArray(a);
    }

    @GetMapping("lesson2b/evenNumbers")
    public int[] evenNumbers(@RequestParam("a") int a) {
        return Lesson2b.evenNumbers(a);
    }

    @GetMapping("lesson2b/min")
    public int min(@RequestParam("a") int[] a) {
        return Lesson2b.min(a);
    }

    @GetMapping("lesson2b/max")
    public int max(@RequestParam("a") int[] a) {
        return Lesson2b.max(a);
    }

    @GetMapping("lesson2b/sum")
    public int sum(@RequestParam("a") int[] a) {
        return Lesson2b.sum(a);
    }

    @GetMapping("lesson2b/fibonacci")
    public int fibonacci(@RequestParam("a") int a) {
        return Lesson2b.fibonacci(a);
    }

    @GetMapping("lesson2b/sequence3n")
    public int sequence3n(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson2b.sequence3n(a, b);
    }

    @GetMapping("lesson2b/multiplyTable")
    public int multiplyTable(@RequestParam("a") int a, @RequestParam("b") int b) {
        Lesson2b.multiplyTable(a, b);
        return a*b;
    }
}
