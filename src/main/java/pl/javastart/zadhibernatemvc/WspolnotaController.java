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
public class WspolnotaController {

    @Autowired
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/wspolnoty")
    public String list(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Wspolnota> query = entityManager.createQuery("select w from Wspolnota w", Wspolnota.class);
        List<Wspolnota> resultList = query.getResultList();

        model.addAttribute("wspolnoty", resultList);

        return "wspolnoty";
    }

    @GetMapping("/wspolnota/{id}")
    public String info(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Wspolnota wspolnota = entityManager.find(Wspolnota.class, id);

        model.addAttribute("wspolnota", wspolnota);
        return "wspolnota";
    }


    @GetMapping("/wspolnota/dodaj")
    public String dodajWspolnote(Model model) {
        model.addAttribute("wspolnota", new Wspolnota());
        return "nowaWspolnota";
    }

    @PostMapping("/wspolnota/dodaj")
    public String dodajWspolnote2(Wspolnota wspolnota) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(wspolnota);
        entityManager.getTransaction().commit();

        return "DodanieWspolnotySuccess";
    }


    @GetMapping("/wspolnota/edycja/{id}")
    public String edycjaWspolnoty(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Wspolnota wspolnota = entityManager.find(Wspolnota.class, id);
        model.addAttribute("wspolnota", wspolnota);

        return "edycjaWspolnoty";
    }

    @PostMapping("/wspolnota/edycja/{id}")
    public String edycjaWspolnoty2(Wspolnota wspolnota, @PathVariable Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Wspolnota wspolnotaNew = entityManager.find(Wspolnota.class, id);

        wspolnotaNew.setName(wspolnota.getName());
        wspolnotaNew.setAddress_street(wspolnota.getAddress_street());
        wspolnotaNew.setAddress_number(wspolnota.getAddress_number());
        wspolnotaNew.setVoivodship(wspolnota.getVoivodship());

        entityManager.getTransaction().begin();
        entityManager.persist(wspolnotaNew);
        entityManager.getTransaction().commit();

        return "redirect:/wspolnota/" + wspolnota.getId();
    }

    @GetMapping("/usun/{id}")
    public String usuwanie(@PathVariable Long id, Model model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Wspolnota wspolnota = entityManager.find(Wspolnota.class, id);
        entityManager.remove(wspolnota);
        return "redirect:/wspolnoty/";
    }
}
