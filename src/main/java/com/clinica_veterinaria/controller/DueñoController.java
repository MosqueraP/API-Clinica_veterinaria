package com.clinica_veterinaria.controller;

import com.clinica_veterinaria.model.Dueño;
import com.clinica_veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DueñoController {

    @Autowired
    private IDuenioService dueServ;

    //crear un nuevo dueño
    @PostMapping("/dueños/create")
    private String saveDueño(@RequestBody Dueño due){
        dueServ.saveDueño(due);
        return "Dueño guardado satisfactoriamente";
    }

    // obtener todos los dueños
    @GetMapping("dueños/traer")
    public List<Dueño> getDueño(){
        return dueServ.getDueño();
    }

    // borrar un dueño según su Id
    @DeleteMapping("/dueños/borrar/{id}")
    public String deleteDueño(@PathVariable Long id){
        dueServ.deleteDueño(id);
        return "Dueño borrado satisfactoriamente";
    }

    // modificar los datos de un dueño
    @PutMapping("/dueños/editar")
    public Dueño editDueño(@RequestBody Dueño due ){
        dueServ.editDueño(due);

        // devolver el objeto modificado traído desde IDueñoService
        return dueServ.findDueño(due.getId());
    }


}