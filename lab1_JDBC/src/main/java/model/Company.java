package main.java.model;

public class Company {
    private int id;
    private String name;
    private int directorID;

    public Company(int id, String name, int directorID) {
        this.id = id;
        this.name = name;
        this.directorID = directorID;
    }

    public Company(String name, int directorID) {
        this.name = name;
        this.directorID = directorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directorID=" + directorID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (directorID != company.directorID) return false;
        return name.equals(company.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + directorID;
        return result;
    }
}
