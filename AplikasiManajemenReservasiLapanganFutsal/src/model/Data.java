package model;

public abstract class Data {

    protected int id;

    public Data() {

    }

    public Data(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void tampilData();

}