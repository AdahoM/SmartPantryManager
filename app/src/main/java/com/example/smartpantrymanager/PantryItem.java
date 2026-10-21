package com.example.smartpantrymanager;

public class PantryItem {
    private int id;
    private String name;
    private String quantity;
    private String unit;
    private int expiry;

    public PantryItem(){}

    public PantryItem(String name, String quantity, String unit, int expiry){
        this.name=name; this.quantity=quantity; this.unit=unit; this.expiry=expiry;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public String getQuantity(){ return quantity; }
    public void setQuantity(String quantity){ this.quantity=quantity; }
    public String getUnit(){ return unit; }
    public void setUnit(String unit){ this.unit=unit; }
    public int getExpiry(){ return expiry; }
    public void setExpiry(int expiry){ this.expiry=expiry; }
}
