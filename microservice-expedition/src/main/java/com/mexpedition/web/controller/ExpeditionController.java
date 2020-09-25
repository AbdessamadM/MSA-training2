package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.model.Expedition;
import com.mexpedition.web.exceptions.ExpeditionNotFoundException;
import com.mexpedition.web.exceptions.ImpossibleAjouterExpeditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    // save expedition
    @PostMapping(value="/Expedition")
    public ResponseEntity<Expedition> nouvelleExpedition(@RequestBody Expedition expedition){

        Expedition nouvelleExpedition = expeditionDao.save(expedition);
        if(nouvelleExpedition == null) throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter cette expedition");

        return new ResponseEntity<Expedition>(nouvelleExpedition, HttpStatus.CREATED);
    }

    // get expedition by id
    @GetMapping(value = "/Expedition/{id}")
    public Expedition recupererUneExpedition(@PathVariable("id") int id) {
        Optional<Expedition> expedition = expeditionDao.findById(id);

        if(!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas!");

        return expedition.get();
    }

    @PutMapping(value = "/Expedition")
    public void modifierExpedition(@RequestBody Expedition expedition){
        expeditionDao.save(expedition);
    }
}
