
package cl.eftec.abril3.entidades;

import javax.persistence.*;

@Entity
public class Coffee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCoffee;
    private String name;
    private int price;
    private int stock;

    /**
     * @return the idCoffee
     */
    public int getIdCoffee() {
        return idCoffee;
    }

    /**
     * @param idCoffee the idCoffee to set
     */
    public void setIdCoffee(int idCoffee) {
        this.idCoffee = idCoffee;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
