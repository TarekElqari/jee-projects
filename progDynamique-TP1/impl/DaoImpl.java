package impl;

import dao.IDao;

public class DaoImpl implements IDao {
    @Override
    public double getValue() {
        return 100.0;
    }
}