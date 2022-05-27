package az.evimtekstil.mhr.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer positionId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    public Position(Integer positionId, String name, List<Employee> employees) {
        this.positionId = positionId;
        this.name = name;
        this.employees = employees;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
