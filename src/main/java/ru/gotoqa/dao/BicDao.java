package ru.gotoqa.dao;

import ru.gotoqa.model.Bic;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */
public interface BicDao {
    public void addBic(Bic bic);
    public void removeBic(int id);
    public void updateBic(Bic bic);
    public Bic getBicById(int id);
    public List<Bic> listBics();
}
