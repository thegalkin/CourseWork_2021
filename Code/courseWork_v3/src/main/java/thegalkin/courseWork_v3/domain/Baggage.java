package thegalkin.courseWork_v3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class Baggage {
    @Id
    Long id;
    String ownerFullName;
    Long flightId;
    String targetFlightName;
    String startCountry;
    List<String> middleCountries;
    String endCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public List<String> getMiddleCountries() {
        return middleCountries;
    }

    public void setMiddleCountries(List<String> middleCountries) {
        this.middleCountries = middleCountries;
    }

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public Baggage(Long id, String ownerFullName, Long flightId, String targetFlightName, String startCountry, List<String> middleCountries, String endCountry) {
        this.id = id;
        this.ownerFullName = ownerFullName;
        this.flightId = flightId;
        this.targetFlightName = targetFlightName;
        this.startCountry = startCountry;
        this.middleCountries = middleCountries;
        this.endCountry = endCountry;
    }
}
