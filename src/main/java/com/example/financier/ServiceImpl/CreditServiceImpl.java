package com.example.financier.ServiceImpl;

import com.example.financier.DTO.CreditDTO;
import com.example.financier.Model.Client;
import com.example.financier.Model.Compte;
import com.example.financier.Model.Credit;
import com.example.financier.Repository.CompteRepository;
import com.example.financier.Repository.CreditRepository;
import com.example.financier.Service.ClientService;
import com.example.financier.Service.CreditService;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CreditServiceImpl implements CreditService {

    @Autowired
    ClientService clientService;
    @Autowired
    CreditRepository creditRepository;

    @Override
    public Credit demanderCredit(CreditDTO credit)
    {
        Credit creditSaved=covertCreditDtoToCredit(credit);
        if(creditSaved!=null) return creditRepository.save(creditSaved);
        return null;
    }

    @Override
    public Credit updateCredit(CreditDTO credit) {

     return null;
    }

    @Override
    public void approveCredit(Long id)
    {
    }

    @Override
    public void desapproveCredit(Long id)
    {
    }

   public Credit covertCreditDtoToCredit(CreditDTO creditDTO)
   {

       Optional<Client> client=clientService.getClientById(creditDTO.getClientId());
       if (client.isPresent())
       {Credit credit=new Credit();
           credit.setMontantCredit(creditDTO.getMontantCredit());
           credit.setClient(client.get());
           credit.setDateDemande(LocalDate.now());
           credit.setDescription(creditDTO.getDescription());
           return credit;
       }
       return null;
   }
}
