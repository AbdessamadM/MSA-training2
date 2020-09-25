package com.mclientui.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpeditionBean {

    private int id;
    private int idCommande;
    private int etat;
}
