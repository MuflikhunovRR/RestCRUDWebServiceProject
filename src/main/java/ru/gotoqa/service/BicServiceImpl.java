package ru.gotoqa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gotoqa.dao.BicDao;
import ru.gotoqa.model.Bic;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */

@Service
public class BicServiceImpl implements BicService {

    private BicDao bicDao;

    public void setBicDao(BicDao bicDao) {
        this.bicDao = bicDao;
    }

    @Override
    @Transactional
    public void addBic(Bic bic) {
        this.bicDao.addBic(bic);
    }

    @Override
    @Transactional
    public void removeBic(int id) {
        this.bicDao.removeBic(id);
    }

    @Override
    @Transactional
    public void updateBic(Bic bic) {
        this.bicDao.updateBic(bic);
    }

    @Override
    @Transactional
    public Bic getBicById(int id) {
        return this.bicDao.getBicById(id);
    }

    @Override
    @Transactional
    public List<Bic> listBics() {
        return this.bicDao.listBics();
    }
}
