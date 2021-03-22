package in.himanshu.recipe.dao;

import in.himanshu.recipe.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int  theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
