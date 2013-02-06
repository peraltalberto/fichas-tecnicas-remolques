// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.fichas_a4.persistencia.models;



import es.zurixconsulting.fichas_a4.persistencia.AbstractModel;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Combustible;
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
public class CombustibleModel extends AbstractModel {
    
    public CombustibleModel() {
        super(Combustible.class);
    }
    
    @Override
    public ArrayList<Combustible> getLista() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        return (ArrayList<Combustible>) session.createCriteria(Combustible.class).list();
    }
    
    
}
