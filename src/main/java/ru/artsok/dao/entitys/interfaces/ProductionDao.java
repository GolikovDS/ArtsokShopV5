package ru.artsok.dao.entitys.interfaces;


public interface ProductionDao {
    public void insert(byte[] bytes);
    public void deleteByNameProduction(String nameProduction);
    public void updateByNameProduction(String nameProduction);
    public byte[] getMainImage();
    public String getMainText();
    public byte[] getImage(int numb);
    public String getDescription();
}
