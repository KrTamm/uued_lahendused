package ee.bcs.valiit.controll;

import ee.bcs.valiit.tasks.Lesson2c;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2cController {

    @GetMapping("lesson2c/nextElement")
    public int nextElement(@RequestParam("a") int a) {
        return Lesson2c.nextElement(a);
    }

    @GetMapping("lesson2c/getSeqLength")
    public int getSeqLength(@RequestParam("a") int a) {
        return Lesson2c.getSeqLength(a);
    }

    @GetMapping("lesson2c/sequence3n")
    public int sequence3n(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson2c.sequence3n(a, b);
    }
}
