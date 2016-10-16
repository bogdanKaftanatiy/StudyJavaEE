package entities;

public class Vacancy {
    private int id;
    private Company company;
    private String position;
    private String requirements;
    private String description;
    private String email;

    public Vacancy() {
    }

    public Vacancy(int id, Company company, String position, String requirements, String description, String email) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.requirements = requirements;
        this.description = description;
        this.email = email;
    }

    public Vacancy(Company company, String position, String requirements, String description, String email) {
        this.company = company;
        this.position = position;
        this.requirements = requirements;
        this.description = description;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (id != vacancy.id) return false;
        if (!company.equals(vacancy.company)) return false;
        if (!position.equals(vacancy.position)) return false;
        if (!requirements.equals(vacancy.requirements)) return false;
        if (description != null ? !description.equals(vacancy.description) : vacancy.description != null) return false;
        return email.equals(vacancy.email);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + company.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + requirements.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", company=" + company +
                ", position='" + position + '\'' +
                ", requirements='" + requirements + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
