package com.jasmine.boot.pojo;


public class Order {
    private Integer id;
    private Integer money;
    private Integer state;
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }



    public Order(Integer id, Integer money, Integer state, Integer version) {
        this.id = id;
        this.money = money;
        this.state = state;
        this.version = version;

    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", money=" + money +
                ", state=" + state +
                ", version=" + version+
                '}';
    }
}
