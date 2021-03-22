package in.himanshu.recipe.controller.rest;

import in.himanshu.recipe.entity.Employee;
import in.himanshu.recipe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employee}")
    public Employee findEmployee(@PathVariable int employee){
        Employee theEmployee = employeeService.findById(employee);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found: "+employee);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
//        force change id if it is set to anything other then 0
        if(theEmployee.getId()!=0){
            theEmployee.setId(0);
        }
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId){
        Employee findEmployee = employeeService.findById(employeeId);

        if(findEmployee!=null){
            employeeService.deleteById(employeeId);
            return "Employee id deleted successfully.";
        }else{
            throw new RuntimeException("EMployee not found: "+employeeId);
        }
    }

}
