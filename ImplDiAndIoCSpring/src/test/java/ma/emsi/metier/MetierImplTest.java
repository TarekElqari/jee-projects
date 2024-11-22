package ma.emsi.metier;


import junit.framework.Assert;
import ma.emsi.dao.DaoImpl;
import ma.emsi.metier.MetierImpl;
import org.junit.jupiter.api.Test;


public class MetierImplTest {
    @Test
    public void testCalcul() {
        MetierImpl metier = new MetierImpl();
        metier.setDao(new DaoImpl());
        double result = metier.calcul();
        Assert.assertEquals(200.0, result, 0.0);
    }
}
