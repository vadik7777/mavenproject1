/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Вадик
 */
@WebServlet(name = "Find", urlPatterns = {"/find"})

public class Find extends HttpServlet {
    
    private EntityManagerFactory entityManagerFactory;

    protected EntityManager getEntityManager() {
        try {
            if (entityManagerFactory == null) {
                synchronized (this) {
                    entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_mavenproject1_war_1.0-SNAPSHOTPU");
                }
            }
            return entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            System.out.println("Проблемы с подключением к базе данных.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String family = request.getParameter("family").toLowerCase();
        String name = request.getParameter("name").toLowerCase();
        String lastname = request.getParameter("lastname").toLowerCase();
        String city = request.getParameter("city").toLowerCase();
        String marka = request.getParameter("marka").toLowerCase();
        String model = request.getParameter("model").toLowerCase();
        String nomer = request.getParameter("nomer").toLowerCase();
        EntityManager em = getEntityManager();
        if (em == null) {
            processRequestErrorBD(response);
        }
        List<Fio> fio = null;
        if (family.equals("") && name.equals("") && lastname.equals("") && city.equals("") && marka.equals("")
                && model.equals("") && nomer.equals("")) {
            processRequestErrorParam(response);
            return;     
        }
        try {
            //System.out.println(em.createQuery("SELECT f FROM Fio f WHERE f.id in (SELECT fc.idfio.id from Fiocar fc WHERE fc.idcar.model=:model)").setParameter("model", model).getResultList());
            fio = em.createQuery("SELECT f FROM Fio f WHERE (:family ='' or f.family=:family)"
                    + "AND (:name ='' or f.name=:name) "
                    + "AND (:lastname ='' or f.lastname=:lastname) "
                    + "AND (:city ='' or f.idcity.name=:city) "
                    + "AND (:marka='' or (f.id in (SELECT fc.idfio.id FROM Fiocar fc WHERE fc.idcar.marka=:marka)))"
                    + "AND (:model='' or (f.id in (SELECT fc.idfio.id FROM Fiocar fc WHERE fc.idcar.model=:model)))"
                    + "AND (:nomer='' or (f.id in (SELECT fc.idfio.id FROM Fiocar fc WHERE fc.idcar.nomer=:nomer)))"
            ).setParameter("family", family).setParameter("name", name)
                    .setParameter("lastname", lastname).setParameter("city", city)
                    .setParameter("marka", marka).setParameter("model", model)
                    .setParameter("nomer", nomer).getResultList();
        } catch (Exception e) {
            System.out.println("Проблемы с данными в базе данных.");
            e.printStackTrace();
        }

        processRequestFromBD(response, fio);

    }

    protected void processRequestErrorBD(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Проблемы с подключением к базе данных.");
        }
    }

    protected void processRequestErrorParam(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Нет входных данных.");
        }
    }

    protected void processRequestFromBD(HttpServletResponse response, List<Fio> fio)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (fio != null) {
                out.println("Найдено записей: " + fio.size() + " шт.");
                out.println("<br/>");
                for (int i = 0; i < fio.size(); i++) {
                    out.print((i + 1) + ") ФИО: " + fio.get(i).getFamily().substring(0, 1).toUpperCase() + fio.get(i).getFamily().substring(1) + " "
                            + fio.get(i).getName().substring(0, 1).toUpperCase() + fio.get(i).getName().substring(1) + " "
                            + fio.get(i).getLastname().substring(0, 1).toUpperCase() + fio.get(i).getLastname().substring(1) + ". ГОРОД: "
                            + fio.get(i).getIdcity().getName().substring(0, 1).toUpperCase()
                            + fio.get(i).getIdcity().getName().substring(1) + ".");
                    for (int j = 0; j < fio.get(i).getFiocarList().size(); j++) {
                        if (fio.get(i).getFiocarList().size() > 1) {
                            out.print(" АВТОМОБИЛЬ " + (j + 1) + " - МАРКА: " + fio.get(i).getFiocarList().get(j).getIdcar().getMarka().substring(0, 1).toUpperCase()
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getMarka().substring(1) + ", МОДЕЛЬ: "
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getModel().substring(0, 1).toUpperCase()
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getModel().substring(1) + ", "
                                    + "НОМЕР: " + fio.get(i).getFiocarList().get(j).getIdcar().getNomer() + ".");
                        } else {
                            out.print(" АВТОМОБИЛЬ - МАРКА: " + fio.get(i).getFiocarList().get(j).getIdcar().getMarka().substring(0, 1).toUpperCase()
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getMarka().substring(1) + ", МОДЕЛЬ: "
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getModel().substring(0, 1).toUpperCase()
                                    + fio.get(i).getFiocarList().get(j).getIdcar().getModel().substring(1) + ", "
                                    + "НОМЕР: " + fio.get(i).getFiocarList().get(j).getIdcar().getNomer() + ".");
                        }
                    }
                    if (fio.size() > 1) {
                        out.println("<br/>");
                    }
                }
            } else {
                out.println("Записей не найдено.");
            }
        }
    }

}
