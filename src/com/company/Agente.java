package com.company;

public class Agente  {
    private int x;
    private int y;
    private String descricao;


    public Agente(int x, int y, String descricao) {
        this.x = x;
        this.y = y;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
