package com.clinica_veterinaria.service;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    // métodos abstractos

    // métodos traer Mascota (LECTURA)
    public List<Mascota> getMascota();

    // métodos para guardar una Mascota (ALTA)
    public void saveMascota(Mascota mas);

    // métodos para eliminar una Mascota (ALTA)
    public void deleteMascota(Long id);


    // métodos para buscar una Mascota (ALTA)
    public Mascota findMascota(Long id);

    // métodos para editar una Mascota (DELETE)
    public void editMascota(Mascota due);


    public List<Mascota> getCaniches();

    public List<MascoDuenioDTO> getMascoDuenios();


}