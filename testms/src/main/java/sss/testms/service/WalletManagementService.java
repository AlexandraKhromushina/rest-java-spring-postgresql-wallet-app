package sss.testms.service;

import sss.testms.model.Wallet;
import sss.testms.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WalletManagementService {

    // Creating the instance of Random class
    Random r = new Random();

    @Autowired
    private WalletRepository walletRepository;

    // Создание кошельков
    public Wallet createEmptyWallet() {
        Wallet wallet = new Wallet();
        return walletRepository.save(wallet);
    }

    public Wallet createNonEmptyWallet() {
        Wallet wallet = new Wallet();
        wallet.deposit(r.nextInt(1000000)+0.01);
        return walletRepository.save(wallet);
    }

    // Добавление средств
    public void deposit(UUID id, double amount) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(() -> new RuntimeException("Кошелек не найден"));
        wallet.deposit(amount); // Я не совсем понимаю, нужно ли мне здесь ловить возможные IllegalArgumentException, или спринг их и без меня обработает
        walletRepository.save(wallet);
    }

    // Списание средств
    public void withdraw(UUID id, double amount) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(() -> new RuntimeException("Кошелек не найден"));
        wallet.withdraw(amount);
        walletRepository.save(wallet);
    }
}
