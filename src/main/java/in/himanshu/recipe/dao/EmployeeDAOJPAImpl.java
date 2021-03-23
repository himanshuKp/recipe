package in.himanshu.recipe.dao;

import in.himanshu.recipe.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query findListQuery = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = findListQuery.getResultList();

        return allEmployees;
    }

    @Override
    public Employee findById(int theId) {
        Employee findEmployee = entityManager.find(Employee.class, theId);

        return findEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee saveEmployee = entityManager.merge(theEmployee);

        theEmployee.setId(saveEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query deleteEmployee = entityManager.createQuery("delete from Employee where id=:employeeid");
        deleteEmployee.setParameter("employeeid", theId);

        deleteEmployee.executeUpdate();
    }
}
