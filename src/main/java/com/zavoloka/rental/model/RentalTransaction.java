package com.zavoloka.rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RentalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime transactionTime;
    private Long clientId;
    private Long propertyId;
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalTransaction that = (RentalTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionTime, clientId, propertyId, amount);
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "id=" + id +
                ", transactionTime=" + transactionTime +
                ", clientId=" + clientId +
                ", propertyId=" + propertyId +
                ", amount=" + amount +
                '}';
    }
}
