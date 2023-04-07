package com.example.financier.Service;

import com.example.financier.DTO.CreditDTO;
import com.example.financier.Model.Credit;

public interface CreditService {


    public Credit demanderCredit(CreditDTO credit);
    public Credit updateCredit(CreditDTO credit);
    public void approveCredit(Long id);
    public void desapproveCredit(Long id);

}
