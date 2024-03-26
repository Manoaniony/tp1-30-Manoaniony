/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tp1Manoaniony.jsf;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.tp1Manoaniony.entity.Customer;
import mg.itu.tp1Manoaniony.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList.
 *
 * @author ramarolahymanoaniony
 */
@Named(value = "customerBean")
/*@RequestScoped*/
@ViewScoped
public class CustomerBean implements Serializable {
    private List<Customer> customerList;  

    @Inject
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

}
