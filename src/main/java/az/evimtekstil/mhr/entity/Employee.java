package az.evimtekstil.mhr.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer employeeId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Position position;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "monthly_salary")
    private Float monthlySalary;

    @Column(name = "daily_salary")
    private Float dailySalary;

    public Employee() {
    }

    public Employee(Integer employeeId, Position position, String name, String surname, Float salary) {
        this.employeeId = employeeId;
        this.position = position;
        this.name = name;
        this.surname = surname;
        this.monthlySalary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Float getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(Float dailySalary) {
        this.dailySalary = dailySalary;
    }
}
