package pl.javastart.zadhibernatemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/")
    public String list(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        List<Employee> resultList = query.getResultList();

        model.addAttribute("employees", resultList);

        return "index";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, id);

        model.addAttribute("employee", employee);

        return "info";
    }

    @GetMapping("/edycja/{id}")
    public String edycja(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, id);

        model.addAttribute("employee", employee);

        return "edit";
    }

    @PostMapping("/edycja/{id}")
    public String edycja2(Employee employee, @PathVariable Long id)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employeeNew = entityManager.find(Employee.class, id);

        employeeNew.setName(employee.getName());
        employeeNew.setSurname(employee.getSurname());

        entityManager.getTransaction().begin();
        entityManager.persist(employeeNew);
        entityManager.getTransaction().commit();

        return "redirect:/edycja/" + employee.getId();
    }

}
