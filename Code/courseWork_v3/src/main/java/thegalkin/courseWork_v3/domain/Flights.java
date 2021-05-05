package thegalkin.courseWork_v3.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
public class Flights {
    @Id
    private Long id;
    private String flightName;
    private String planeId;
    private String prevFlightName; //коннекшн с предыдущим полетом
    private Time startTime;
    private Time endTime;
    private String planeModel;
    private String startCountry;
    private String endCountry;
    private String startCity;
    private String endCity;
    private Integer passengersAmount;
    private List<Integer> seatsNumbers;
    private List<String> seatsFullNames;
    private List<Long> personnelIds;
    private List<Long> baggageIds;

    public Flights(Long id, String flightName, String planeId, String prevFlightName, Time startTime, Time endTime, String planeModel, String startCountry, String endCountry, String startCity, String endCity, Integer passengersAmount, List<Integer> seatsNumbers, List<String> seatsFullNames, List<Long> personnelIds, List<Long> baggageIds) {
        this.id = id;
        this.flightName = flightName;
        this.planeId = planeId;
        this.prevFlightName = prevFlightName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.planeModel = planeModel;
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.startCity = startCity;
        this.endCity = endCity;
        this.passengersAmount = passengersAmount;
        this.seatsNumbers = seatsNumbers;
        this.seatsFullNames = seatsFullNames;
        this.personnelIds = personnelIds;
        this.baggageIds = baggageIds;
    }

    public List<Integer> getSeatsNumbers() {
        return seatsNumbers;
    }

    public void setSeatsNumbers(List<Integer> seatsNumbers) {
        this.seatsNumbers = seatsNumbers;
    }

    public List<String> getSeatsFullNames() {
        return seatsFullNames;
    }

    public void setSeatsFullNames(List<String> seatsFullNames) {
        this.seatsFullNames = seatsFullNames;
    }

    public List<Long> getPersonnelIds() {
        return personnelIds;
    }

    public void setPersonnelIds(List<Long> personnelIds) {
        this.personnelIds = personnelIds;
    }

    public List<Long> getBaggageIds() {
        return baggageIds;
    }

    public void setBaggageIds(List<Long> baggageIds) {
        this.baggageIds = baggageIds;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getPrevFlightName() {
        return prevFlightName;
    }

    public void setPrevFlightName(String prevFlightName) {
        this.prevFlightName = prevFlightName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Integer getPassengersAmount() {
        return passengersAmount;
    }

    public void setPassengersAmount(Integer passengersAmount) {
        this.passengersAmount = passengersAmount;
    }


}
