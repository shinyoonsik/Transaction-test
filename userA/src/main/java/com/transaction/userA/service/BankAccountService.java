package com.transaction.userA.service;

import com.transaction.userA.Entity.BankAccount;
import com.transaction.userA.domain.dto.BankAccountDto;
import com.transaction.userA.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountService.class);
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Transactional
    public BankAccount saveBankAccount(BankAccount bankAccount){
        LOGGER.info("saveBankAccount 실행");
        return bankAccountRepository.save(bankAccount);
    }

    @Transactional
    public BankAccountDto getBankAccount(long id){
        LOGGER.info("getBankAccount 실행");
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("no bank account"));
        BankAccountDto bankAccountDto = BankAccountDto.of(bankAccount);
        return bankAccountDto;
    }

}
