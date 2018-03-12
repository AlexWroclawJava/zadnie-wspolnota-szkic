package pl.javastart.zadhibernatemvc;

import javax.persistence.*;

@Entity
public class Mieszkaniec {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String plec;

    @ManyToOne
    private Wspolnota wspolnota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPlec() {
        return plec;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String wyswietl() {
        String napis = "Lokator={id=" + id + ", imię='" + name + ", nazwisko='" + surname + '\'' + ", płeć=" + plec + "}";
        return napis;
    }
}
