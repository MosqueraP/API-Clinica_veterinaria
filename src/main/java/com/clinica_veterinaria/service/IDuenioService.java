package com.clinica_veterinaria.service;

import com.clinica_veterinaria.model.Dueño;

import java.util.List;

public interface IDuenioService {

    // métodos abstractos

    // métodos traer Dueños (LECTURA)
    public List<Dueño> getDueño();

    // métodos para guardar un dueño (ALTA)
    public void saveDueño(Dueño due);


    public void deleteDueño(Long id);


    public Dueño findDueño(Long id);

    public void editDueño(Dueño due);

}
