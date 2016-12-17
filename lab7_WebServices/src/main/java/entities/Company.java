package entities;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "companies", schema = "lab3_jpa")
@NamedQuery(name = "Company.getAll", query = "SELECT c FROM Company c")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 128)
    private String name;
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "directorID", unique = true, nullable = false)
    @JsonManagedReference
    private Director director;

    public Company() {
    }

    public Company(int id, String name, Director director) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.director.setCompany(this);
    }

    public Company(String name, Director director) {
        this.name = name;
        this.director = director;
        this.director.setCompany(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        if(this.director != null)
            this.director.setCompany(null);
        this.director = director;
        this.director.setCompany(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (!name.equals(company.name)) return false;
        return director.equals(company.director);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + director.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director=" + director +
                '}';
    }
}
