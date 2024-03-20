package com.clinica_veterinaria.controller;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Mascota;
import com.clinica_veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotaServ;

    //crear una nueva mascota
    @PostMapping("/mascotas/create")
    private String saveMascota(@RequestBody Mascota mas){
        mascotaServ.saveMascota(mas);
        return "Mascota guardada satisfactoriamente";
    }

    // obtener todas las mascotas
    @GetMapping("mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascotaServ.getMascota();
    }

    // borrar una mascota según su Id
    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascotaServ.deleteMascota(id);
        return "Mascota eliminada satisfactoriamente";
    }

    // modificar los datos de una mascota
    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota mas ){
        mascotaServ.editMascota(mas);

        // devolver el objeto modificado traído desde IMascotaService
        return mascotaServ.findMascota(mas.getId());
    }

    @GetMapping("/mascotas/traer-caniches")
    public List<Mascota> traerCaniches() {
        return mascotaServ.getCaniches();
    }

    @GetMapping ("mascotas/traer-duenios")
    public List<MascoDuenioDTO> traerMascoDuenios () {

        return mascotaServ.getMascoDuenios();

    }


}
