package ee.bcs.valiit.controll;


import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    @GetMapping("lesson2/generateArray")
    public int[] generateArray(@RequestParam("a") int a) {
        return Lesson2.generateArray(a);
    }

    @GetMapping("lesson2/decreasingArray")
    public int[] decreasingArray(@RequestParam("a") int a) {
        return Lesson2.decreasingArray(a);
    }

    @GetMapping("lesson2/yl13")
    public int[] yl13(@RequestParam("a") int a) {
        return Lesson2.yl3(a);
    }

    @GetMapping("lesson2/sampleArray")
    public int[] sampleArray() {
        return Lesson2.sampleArray();
    }

    @GetMapping("lesson2/firstN")
    public int[] firstN(@RequestParam("a") int a) {
        return Lesson2.firstN(a);
    }
}
