package com.transaction.userA.controller;

import com.transaction.userA.Entity.BankAccount;
import com.transaction.userA.domain.dto.BankAccountDto;
import com.transaction.userA.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @GetMapping(path = "bank_accounts/{id}")
    public BankAccountDto getBankAccount(@PathVariable long id){
        BankAccountDto bankAccountDto = bankAccountService.getBankAccount(id);

        return bankAccountDto;
    }

    @PostMapping(path = "bank_accounts")
    public BankAccountDto createBankAccount(@RequestBody BankAccountDto bankAccountDto){
        BankAccount bankAccount = BankAccount.of(bankAccountDto);
        BankAccount savedBankAccount = bankAccountService.saveBankAccount(bankAccount);
        BankAccountDto savedBankAccountDto = BankAccountDto.of(savedBankAccount);

        return savedBankAccountDto;
    }
}
