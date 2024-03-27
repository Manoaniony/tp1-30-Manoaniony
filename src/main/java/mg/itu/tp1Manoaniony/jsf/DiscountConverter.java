/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tp1Manoaniony.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import mg.itu.tp1Manoaniony.entity.Discount;
import mg.itu.tp1Manoaniony.service.DiscountManager;

@FacesConverter(value = "discountConverter", managed = true)
public class DiscountConverter implements Converter<Discount> {

    @Inject
    private DiscountManager discountManager;

    /**
     * Convertit une String en Discount.
     *
     * @param context
     * @param component
     * @param value valeur à convertir
     * @return
     */
    @Override
    public Discount getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return discountManager.findById(value);
    }

    /**
     * Convertit un Discount en String.
     *
     * @param context
     * @param component
     * @param discount
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Discount discount) {
        if (discount == null) {
            return "";
        }
        return discount.getCode();
    }
}
