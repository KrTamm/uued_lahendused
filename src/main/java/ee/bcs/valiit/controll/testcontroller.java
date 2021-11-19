package ee.bcs.valiit.controll;

import ee.bcs.valiit.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class testcontroller {


    //localhost:8080/employee/5
    @GetMapping("hello/{name}")
    public String helloWorld(@PathVariable("name") String employeeName) {
        return "Hello " + employeeName;
    }


    @GetMapping("dtoTest")
    public Book dtoTest() {
        Book book = new Book();
        book.setName("Eesti muinasjutud");
        book.setAuthor("Jaan Juurikas");
        book.setYear(1992);
        book.setHinnang(6);
        return book;
    }

    @PostMapping("dtoTest")
    public Book saveBook(@RequestBody Book book) {

        return book;
    }
}
