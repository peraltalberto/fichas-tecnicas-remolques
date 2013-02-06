// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.fichas_a4.persistencia.models;



import es.zurixconsulting.fichas_a4.persistencia.AbstractModel;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Fichatecnica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author aperalta
 */
public class FichasModel extends AbstractModel {
    
    public FichasModel() {
        super(Fichatecnica.class);
    }
    
    @Override
    public ArrayList<Fichatecnica> getLista() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        return (ArrayList<Fichatecnica>) session.createCriteria(Fichatecnica.class).addOrder(Order.desc("fechatarjeta")).list();
    }
    
   
    public ArrayList<Fichatecnica> getBusqueda(String bus) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        return (ArrayList<Fichatecnica>) session.createCriteria(Fichatecnica.class)
                .add(Restrictions.like("ncertificado", "%"+bus+"%"))
                .addOrder(Order.desc("fechatarjeta")).list();
    }
    public int getContadorAnual(){
        SimpleDateFormat anyo = new SimpleDateFormat("yyyy");
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql =  "select count(*) + 1 from FICHATECNICA where YEAR(fechatarjeta) = "+anyo.format(new Date());
        
        return (Integer) session.createSQLQuery(sql).list().get(0);
    }
}
