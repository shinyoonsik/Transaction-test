package com.transaction.userA.Entity;

import com.transaction.userA.domain.dto.BankAccountDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "bank_account")
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "user_name", length = 255)
    private String userName;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();


    public static BankAccount of(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1L);
        bankAccount.setBalance(bankAccountDto.getBalance());
        bankAccount.setUserName(bankAccountDto.getUserName());

        return bankAccount;
    }
}
