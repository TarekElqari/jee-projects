package metier;

import dao.IDao;

public class MetierImpl implements IDao {
    private IDao dao;
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double getValue() {
        return dao.getValue() * 2;
    }
}
