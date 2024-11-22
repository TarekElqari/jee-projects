package ma.emsi.presentation;

import ma.emsi.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println("Resultat = " + metier.calcul());
    }
}
