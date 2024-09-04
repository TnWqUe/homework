package ru.mpei.homework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Current")
public class Current {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double ia;
    @Column
    private double ib;
    @Column
    private double ic;

    public Current(double ia,double ib,double ic) {
        this.ia = ia;
        this.ib = ib;
        this.ic = ic;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Current current = (Current) o;
        return id == current.id && Double.compare(current.ia, ia) == 0 && Double.compare(current.ib, ib) == 0 && Double.compare(current.ic, ic) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ia, ib, ic);
    }
}
