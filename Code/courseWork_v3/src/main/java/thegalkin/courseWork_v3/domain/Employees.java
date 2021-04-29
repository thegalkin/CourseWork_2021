package thegalkin.courseWork_v3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class Employees {
    @Id
    Long id;
    String name;
    String secondname;
    String lastname;
    List<String> licenses;
    String role;
    String countryoforigin;
    List<String> visas;


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
