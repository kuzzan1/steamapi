package main.riot.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class GoldDto {

    @JsonProperty
    private int base;
    @JsonProperty
    private boolean purchasable;
    @JsonProperty
    private int sell;
    @JsonProperty
    private int total;

    public int getBase() {
        return base;
    }

    public void setBase( int base ) {
        this.base = base;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable( boolean purchasable ) {
        this.purchasable = purchasable;
    }

    public int getSell() {
        return sell;
    }

    public void setSell( int sell ) {
        this.sell = sell;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal( int total ) {
        this.total = total;
    }
}
