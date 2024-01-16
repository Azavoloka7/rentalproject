package com.zavoloka.rental.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;
@Entity
@Setter
@Getter
public class Client {

    private Long clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private double balance;

    public Client(Long clientId, String name, String email, String phoneNumber, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public void rentProperty(Property property) {
        if (!property.isRented() && this.getBalance() >= property.getRentAmount()) {
            double newBalance = this.getBalance() - property.getRentAmount();
            this.setBalance(newBalance);

            property.setRented(true);

            System.out.println(this.getName() + " has successfully rented property '" + property.getPropertyName() +
                    "' for $" + property.getRentAmount() + ". Remaining balance: $" + this.getBalance());
        } else {
            System.out.println("Property '" + property.getPropertyName() + "' is not available for rent or " +
                    "insufficient funds. Client: " + this.getName() + ", Balance: $" + this.getBalance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
