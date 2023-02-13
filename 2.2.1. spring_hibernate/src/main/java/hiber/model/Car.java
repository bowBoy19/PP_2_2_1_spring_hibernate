package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    long id;

    @Column(name = "model")
    private String model;
    @Column(name = "series")
    int series;

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    private User user;

    public Car() {
    }

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", Series=" + series +
                '}';
    }
}