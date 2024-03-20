package com.clinica_veterinaria.service;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Dueño;
import com.clinica_veterinaria.model.Mascota;
import com.clinica_veterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public List<Mascota> getMascota() {
        List<Mascota> listaMascotas;
        listaMascotas = mascotaRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mas) {
        mascotaRepo.save(mas);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);

    }

    @Override
    public Mascota findMascota(Long id) {
        return mascotaRepo.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Mascota mas) {
        //acá se puede hacer también que edite parte por parte para que sea más detallado
        this.saveMascota(mas);
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> listaMascotas = this.getMascota();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();


        for (Mascota masco:listaMascotas) {
            if (masco.getEspecie().equalsIgnoreCase("perro") && masco.getRaza().equalsIgnoreCase("caniche")) {
                listaCaniches.add(masco);
            }
        }
        return listaCaniches;
    }

    @Override
    public List<MascoDuenioDTO> getMascoDuenios() {
        List<Mascota> listaMascotas = this.getMascota();
        List<MascoDuenioDTO> listaMascoDuenio = new ArrayList<>();
        MascoDuenioDTO masco_duenio = new MascoDuenioDTO();

        for (Mascota masco : listaMascotas) {


            System.out.println(masco.getNombre());
            //masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            //masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());

            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new MascoDuenioDTO();//reseteo
        }
        return listaMascoDuenio;
    }
}
