package org.dtu.matador.game.fields;

import org.dtu.matador.game.Property;

public class Street extends Property {

    int price;
    int rent;
    String owner;

    /**
     *
     * @param name
     * @param subtext
     * @param description
     * @param rent
     * @param color_1
     * @param color_2
     * @param price
     */
    public Street(String name, String subtext, String description, String rent, String color_1, String color_2, String price, String owner) {
        super(name, subtext, description, rent, color_1, color_2, price, owner);
        this.owner = null;
        this.price = Integer.parseInt(price);
        this.rent = Integer.parseInt(rent);
    }



    public void LandOn(String playerName) {
        if (this.owner == null) {
            // TODO ask for purchase
            this.owner = playerName;
        }
        else if (playerName.equals(this.owner)) {

        }
        else {
            // Some other player owns this Street
        }
    }

    // TODO buy()
    // TODO Sell()

    public String print() {
        return "Yo";
    }

}
