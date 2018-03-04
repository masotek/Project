package Servlet;

import javax.persistence.*;

@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "numberOfVisits")
    private Long numberOfVisits;

    public City() {
    }

    public City(String name, Long numberOfVisits) {
        this.name = name;
        this.numberOfVisits = numberOfVisits;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", numberOfVisits=" + numberOfVisits +
                '}';
    }
}





