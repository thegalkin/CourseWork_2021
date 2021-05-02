package thegalkin.courseWork_v3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class Employees {
    @Id
    private Long id;
    private String name;
    private String secondname;
    private String lastname;
    private List<String> licenses;
    private String role;
    private String countryoforigin;
    private List<String> visas;

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

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<String> licenses) {
        this.licenses = licenses;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountryoforigin() {
        return countryoforigin;
    }

    public void setCountryoforigin(String countryoforigin) {
        this.countryoforigin = countryoforigin;
    }

    public List<String> getVisas() {
        return visas;
    }

    public void setVisas(List<String> visas) {
        this.visas = visas;
    }

    public Employees(Long id, String name, String secondname, String lastname, List<String> licenses, String role, String countryoforigin, List<String> visas) {
        this.id = id;
        this.name = name;
        this.secondname = secondname;
        this.lastname = lastname;
        this.licenses = licenses;
        this.role = role;
        this.countryoforigin = countryoforigin;
        this.visas = visas;
    }
}
