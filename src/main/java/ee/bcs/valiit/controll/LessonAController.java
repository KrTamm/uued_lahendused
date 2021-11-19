package ee.bcs.valiit.controll;


import ee.bcs.valiit.tasks.LessonA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonAController {

    //localhost:8080/lessonA/e1?a=5
    @GetMapping("lessonA/e1")
    public int e1(@RequestParam("a") int a) {
        return LessonA.e1(a);
    }

    //localhost:8080/lessonA/e2?a=10&b=20
    @GetMapping("lessonA/e2")
    public int e2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return LessonA.e2(a, b);
    }

    @GetMapping("lessonA/e3")
    public int e3(@RequestParam("a") int a) {
        return LessonA.e3(a);
    }

    @GetMapping("lessonA/e4")
    public int e4(@RequestParam("a1") int a1, @RequestParam("a2") int a2, @RequestParam("b1") int b1, @RequestParam("b2") int b2, @RequestParam("c1") int c1, @RequestParam("c2") int c2) {
        return LessonA.e4(a1, a2, b1, b2, c1, c2);
    }

    @GetMapping("lessonA/e5")
    public int e5() {
        return LessonA.e5();
    }

    @GetMapping("lessonA/e6")
    public boolean e6(@RequestParam("a") int a) {
        return LessonA.e6(a);
    }

    @GetMapping("lessonA/e7")
    public boolean e7(@RequestParam("a") boolean a) {
        return LessonA.e7(a);
    }

    @GetMapping("lessonA/e8")
    public boolean e8(@RequestParam("a") boolean a, @RequestParam("b") boolean b) {
        return LessonA.e8(a, b);
    }

    @GetMapping("lessonA/e9")
    public boolean e9(@RequestParam("a") boolean a, @RequestParam("b") boolean b, @RequestParam("c") boolean c, @RequestParam("d") boolean d) {
        return LessonA.e9(a, b, c, d);
    }

    //localhost:8080/lessonA/e10?a=1,2,3,4,5
    @GetMapping("lessonA/e10")
    public int[] e10(@RequestParam("a") int[] array) {
        LessonA.e10(array);
        return array;
    }

    @GetMapping("lessonA/e11")
    public int[] e11(@RequestParam("a") int[] array) {
        LessonA.e11(array);
        return array;
    }

    @GetMapping("lessonA/e12")
    public int[] e12(@RequestParam("a") int[] array) {
        LessonA.e12(array);
        return array;
    }

    @GetMapping("lessonA/e13")
    public int[] e13(@RequestParam("a") int[] array) {
        LessonA.e13(array);
        return array;
    }

    @GetMapping("lessonA/e14")
    public int[] e14(@RequestParam("a") int[] array) {
        LessonA.e14(array);
        return array;
    }

    @GetMapping("lessonA/e15")
    public int[] e15(@RequestParam("a") int[] array) {
        LessonA.e15(array);
        return array;
    }
}
