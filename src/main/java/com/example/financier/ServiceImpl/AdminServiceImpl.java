package com.example.financier.ServiceImpl;

import com.example.financier.Model.Admin;
import com.example.financier.Repository.AdminRepository;
import com.example.financier.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
