package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Hospital h = new Hospital();
        h.setName("Apollo");
        h.setDescription("Multi Speciality Hospital");
        h.setDate(new Date());
        h.setStatus("Active");

        session.save(h);

        session.getTransaction().commit();

        int id = h.getId();
        Hospital data = session.get(Hospital.class, id);

        System.out.println(data.getName());
        System.out.println(data.getDescription());
        System.out.println(data.getStatus());

        session.close();
        sf.close();
    }
}
