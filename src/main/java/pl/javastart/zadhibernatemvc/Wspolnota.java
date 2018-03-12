package pl.javastart.zadhibernatemvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Wspolnota {

    @Id@GeneratedValue
    private Long id;
    private String name;
    private String address_street;
    private Integer address_number;
    private String voivodship;

    public List<Mieszkaniec> getMieszkaniecList() {
        return mieszkaniecList;
    }

    public void setMieszkaniecList(List<Mieszkaniec> mieszkaniecList) {
        this.mieszkaniecList = mieszkaniecList;
    }

    @OneToMany (mappedBy = "wspolnota")
    private List<Mieszkaniec> mieszkaniecList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress_street() {
        return address_street;
    }
    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }
    public Integer getAddress_number() {
        return address_number;
    }
    public void setAddress_number(Integer address_number) {
        this.address_number = address_number;
    }
    public String getVoivodship() {
        return voivodship;
    }
    public void setVoivodship(String voivodship) {
        this.voivodship = voivodship;
    }
}

