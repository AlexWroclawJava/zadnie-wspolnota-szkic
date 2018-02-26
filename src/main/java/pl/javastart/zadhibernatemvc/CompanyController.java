package pl.javastart.zadhibernatemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/firmy")
    public String list(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Company> query = entityManager.createQuery("select c from Company c", Company.class);
        List<Company> resultList = query.getResultList();

        model.addAttribute("companies", resultList);

        return "companies";
    }

    @GetMapping("/firma/{id}")
    public String info(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Company company = entityManager.find(Company.class, id);

        model.addAttribute("company", company);

        return "company";
    }


    @GetMapping("/firmy/dodaj")
    public String dodaj(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        model.addAttribute("company", new Company());
        return "nowy";
    }

    @PostMapping("/firmy/dodaj")
    public String dodaj2(Company company)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();

        return "DodanieFirmySuccess";
    }

}
