/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public interface OperacionesDB {
    
    public abstract String insert(Object obj);
    public abstract String update(Object obj);
    public abstract String delete(Object obj);
    public abstract ArrayList show();
    
}
