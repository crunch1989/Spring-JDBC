package app.jdbcspring.test;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbcspring.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppTest 
{
   
    
    
    public static void main(String[] args) {
        //AppTest.saveServicio();
        
       // AppTest.getServicio(new Servicio (3));
      AppTest.getAll();
    }
    
    

    public static void saveServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");// referencias al id de jdbc_database.xml

        Servicio servicio = new Servicio();
        
        servicio.setDescripcion("Almuerzo Campestre");
        servicio.setCostoHora(19d);
     

        servicioDAO.save(servicio);
    }
    
    public static void getServicio(Servicio servicio) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        Servicio servicioFull = servicioDAO.get(servicio);
        System.out.println(servicioFull.getDescripcion() + " " + servicioFull.getCostoHora());
    }
   
    
    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }

}
