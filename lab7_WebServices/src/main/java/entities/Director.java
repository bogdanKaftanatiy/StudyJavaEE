package entities;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "directors", schema = "lab3_jpa")
@NamedQuery(name = "Director.getAll", query = "SELECT d FROM Director d")
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", length = 64)
    private String firstname;
    @Column(name = "surname", length = 64)
    private String surname;
    @OneToOne(mappedBy = "director")
    @JsonBackReference
    private Company company;

    public Director() {
    }

    public Director(int id, String firstname, String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public Director(int id, String firstname, String surname, Company company) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.company = company;
    }

    public Director(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Director(String firstname, String surname, Company company) {
        this.firstname = firstname;
        this.surname = surname;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (id != director.id) return false;
        if (!firstname.equals(director.firstname)) return false;
        if (!surname.equals(director.surname)) return false;
        return company != null ? company.equals(director.company) : director.company == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstname.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
