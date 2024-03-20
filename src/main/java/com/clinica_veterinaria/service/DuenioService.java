package com.clinica_veterinaria.service;

import com.clinica_veterinaria.model.Dueño;
import com.clinica_veterinaria.repository.IDueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDueñoRepository dueñoRepo;

    @Override
    public List<Dueño> getDueño() {
        List<Dueño> listaDueños;
        listaDueños = dueñoRepo.findAll();
        return listaDueños;
    }

    @Override
    public void saveDueño(Dueño due) {
        dueñoRepo.save(due);

    }

    @Override
    public void deleteDueño(Long id) {
        dueñoRepo.deleteById(id);
    }

    @Override
    public Dueño findDueño(Long id) {
        return dueñoRepo.findById(id).orElse(null);
    }

    @Override
    public void editDueño(Dueño due) {
        this.saveDueño(due);

    }
}
