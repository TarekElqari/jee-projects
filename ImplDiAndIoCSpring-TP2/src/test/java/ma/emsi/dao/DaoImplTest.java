package ma.emsi.dao;


import junit.framework.Assert;
import ma.emsi.dao.DaoImpl;
import ma.emsi.dao.IDao;
import org.junit.jupiter.api.Test;

public class DaoImplTest {
    @Test
    public void testGetValue() {
        IDao dao = new DaoImpl();
        double value = dao.getValue();
        Assert.assertEquals(100.0, value, 0.0);
    }
}
