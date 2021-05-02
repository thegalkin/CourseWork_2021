package thegalkin.courseWork_v3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class Planes {
    @Id
    Long id;
    String internationalNumber;
    String russianNumber;
    String boardName;
    String model;
    List<String> repairHistory;
    String ownerCompany;
    Integer humanCapacity;
    Integer personnelCapacity;
    Integer baggageCapacity;
    List<Long> flightHistory;

    public Planes(Long id, String internationalNumber, String russianNumber, String boardName, String model, List<String> repairHistory, String ownerCompany, Integer humanCapacity, Integer personnelCapacity, Integer baggageCapacity, List<Long> flightHistory) {
        this.id = id;
        this.internationalNumber = internationalNumber;
        this.russianNumber = russianNumber;
        this.boardName = boardName;
        this.model = model;
        this.repairHistory = repairHistory;
        this.ownerCompany = ownerCompany;
        this.humanCapacity = humanCapacity;
        this.personnelCapacity = personnelCapacity;
        this.baggageCapacity = baggageCapacity;
        this.flightHistory = flightHistory;
    }
}
