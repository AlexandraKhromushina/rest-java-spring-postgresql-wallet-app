package sss.testms.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.;
import java.util.*;
import java.math.*;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private double balance;

    // Дефолтный конструктор
    public Wallet() {
        this.balance = 0; // Начальный баланс равен 0
    }

    // Геттеры и ирландские сеттеры
    public UUID getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Добавление средств
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Значение должно быть положительным");
        }

        this.balance = this.balance + amount;
    }

    // Списание средств
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Значение должно быть положительным");
        }

        double newBalance = this.balance - amount;

        if (newBalance < 0) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }

        this.balance = newBalance;
    }

    // Мне несколько странно, что в подобных операциях почти нигде не принимается на вход id,
    // но много где написано, что лучше делать это через хранение состояния на стороне клиента, так что оставлю
    // пока так
}
