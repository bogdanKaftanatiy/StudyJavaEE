package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidates")
@NamedQuery(name = "Candidate.getAll", query = "SELECT c FROM Candidate c")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "cvURI")
    private String cvURI;
    @ManyToMany(mappedBy = "candidates")
    private List<Vacancy> vacancies;

    public Candidate() {
        vacancies = new ArrayList<Vacancy>();
    }

    public Candidate(int id, String firstname, String surname, String email, String cvURI) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.cvURI = cvURI;
        this.vacancies = new ArrayList<Vacancy>();
    }

    public Candidate(String firstname, String surname, String email, String cvURI) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.cvURI = cvURI;
        this.vacancies = new ArrayList<Vacancy>();
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCvURI() {
        return cvURI;
    }

    public void setCvURI(String cvURI) {
        this.cvURI = cvURI;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public void addVacancy(Vacancy v) {
        vacancies.add(v);
    }

    public void removeVacancy(int id) {
        for (Vacancy v: vacancies) {
            if(v.getId() == id) {
                vacancies.remove(v);
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (id != candidate.id) return false;
        if (!firstname.equals(candidate.firstname)) return false;
        if (!surname.equals(candidate.surname)) return false;
        if (!email.equals(candidate.email)) return false;
        return cvURI.equals(candidate.cvURI);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstname.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + cvURI.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", cvURI='" + cvURI + '\'' +
                '}';
    }
}
