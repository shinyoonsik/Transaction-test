package com.transaction.userA.domain.dto;

import com.transaction.userA.Entity.BankAccount;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    private int balance;
    private String userName;

    public static BankAccountDto of(BankAccount bankAccount){
        BankAccountDto bankAccountDto = new BankAccountDto();

        if(bankAccount.getUserName() != null) bankAccountDto.setUserName(bankAccount.getUserName());
        if(bankAccount.getBalance() != null) bankAccountDto.setBalance(bankAccount.getBalance());

        return  bankAccountDto;
    }
}
