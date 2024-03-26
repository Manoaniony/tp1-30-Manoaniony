/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1Manoaniony.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tp1Manoaniony.entity.Customer;
import mg.itu.tp1Manoaniony.entity.Discount;

/**
 *
 * @author ramarolahymanoaniony
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    
    /**
     * 
     * @return 
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    
    /**
     * 
     * @param code
     * @return 
     */
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
    
    
    /**
     * 
     * @param discount
     * @return 
     */
    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }
}
