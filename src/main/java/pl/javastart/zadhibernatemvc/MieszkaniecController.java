package pl.javastart.zadhibernatemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.util.List;

@Controller
public class MieszkaniecController {

    @Autowired
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;


    @GetMapping("/lista")
    public String list(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Mieszkaniec> query = entityManager.createQuery("select m from Mieszkaniec m", Mieszkaniec.class);
        List<Mieszkaniec> resultList = query.getResultList();

        model.addAttribute("mieszkancy", resultList);

        return "aktualniMieszkancy";
    }



    @GetMapping("/")
    public String home(Model model) {

        return "index";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Mieszkaniec mieszkaniec = entityManager.find(Mieszkaniec.class, id);

        model.addAttribute("mieszkaniec", mieszkaniec);
        return "info";
    }

    @GetMapping("/edycja/{id}")
    public String edycja(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Mieszkaniec mieszkaniec = entityManager.find(Mieszkaniec.class, id);
        model.addAttribute("mieszkaniec", mieszkaniec);

        return "edycjaMieszkanca";
    }

    @PostMapping("/edycja/{id}")
    public String edycja2(Mieszkaniec mieszkaniec, @PathVariable Long id)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Mieszkaniec mieszkaniecNew = entityManager.find(Mieszkaniec.class, id);

        mieszkaniecNew.setName(mieszkaniec.getName());
        mieszkaniecNew.setSurname(mieszkaniec.getSurname());

        entityManager.getTransaction().begin();
        entityManager.persist(mieszkaniecNew);
        entityManager.getTransaction().commit();

        return "redirect:/info/" + mieszkaniec.getId();
    }


    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        model.addAttribute("mieszkaniec", new Mieszkaniec());
        return "dodajMieszkanca";
    }


    @PostMapping("/dodaj")
    public String dodaj2(Mieszkaniec mieszkaniec)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(mieszkaniec);
        entityManager.getTransaction().commit();

        return "index";
    }




}

