package ru.gotoqa.service;

import ru.gotoqa.model.Bic;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */

public interface BicService {
    public void addBic(Bic bic);
    public void removeBic(int id);
    public void updateBic(Bic bic);
    public Bic getBicById(int id);
    public List<Bic> listBics();
}
