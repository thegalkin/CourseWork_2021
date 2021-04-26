package thegalkin.courseWork_v3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.lang.reflect.Array;
import java.util.List;

@Data
@NoArgsConstructor
public class Employee {
    @Id
    Long id;
    String name;
    String secondName;
    String lastName;
    List<String> licenses;
    String role;
    String countryOfOrigin;
    List<String> visas;


    public Employee(Long id, String name, String secondName, String lastName, List<String> licenses, String role, String countryOfOrigin, List<String> visas) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.licenses = licenses;
        this.role = role;
        this.countryOfOrigin = countryOfOrigin;
        this.visas = visas;
    }
}
