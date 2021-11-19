package ee.bcs.valiit.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private List<Employee> employeeList = new ArrayList<>();

    @PostMapping("employee")
    public void saveEmployee(@RequestBody Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, position) VALUES (:name, :position, :country)";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", employee.getName());
        paramMap.put("position", employee.getPosition());
        paramMap.put("country", employee.getCountry());
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("employee")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @GetMapping("employee/{id}")
    public Employee employee(@PathVariable("id") int a) {
        return employeeList.get(a);
    }

    @PutMapping("employee/{id}")
    public Employee employeeSet(@PathVariable("id") int a, @RequestBody Employee employee) {
        return employeeList.set(a, employee);
    }

    @DeleteMapping("employee/{id}")
    public Employee employeeRemove(@PathVariable("id") int a) {
        return employeeList.remove(a);
    }
}
