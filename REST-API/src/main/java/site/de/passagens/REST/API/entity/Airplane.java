package site.de.passagens.REST.API.entity;

import jakarta.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private int maxCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public Airplane() {
        // construtor padrão
    }

    public Airplane(String model) {
        this.model = model;
    }

    public Airplane(String model, Airline airline) {
        this.model = model;
        this.airline = airline;
    }

    public Airplane(String model, int maxCapacity, Airline airline) {
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
        if (airline != null && !airline.getAirplanes().contains(this)) {
            airline.getAirplanes().add(this);
        }
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
