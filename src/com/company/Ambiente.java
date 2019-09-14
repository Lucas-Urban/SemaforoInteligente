package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Ambiente {

    private String ambiente[][];
    private ArrayList<Agente> agentes;

    public Ambiente() {
        this.agentes = new ArrayList<Agente>();
        this.ambiente= new String[30][30];
        geraAmbiente();
    }

    // gera o ambiente inicial
    public void geraAmbiente(){
        Random random = new Random();
        Semaforo semaforo;
        int x=0,y=0,aux=0;

        int qtd_cruzamento = random.nextInt(2);
        if (qtd_cruzamento==0) qtd_cruzamento++;


        //gera os agentes semaforos, que ficarão no centro dos cruzamentos
        x= random.nextInt(15)+10;
        for (int i = 0; i < qtd_cruzamento; i++) {
            y= random.nextInt(15)+10;
            if (i>0){
                if (y - aux > 5 ) { y+=5; }
                if (y - aux > -5 ){ y-=5; }
            }
            aux=y;
            semaforo = new Semaforo(x ,y," S ");
            this.agentes.add(semaforo);
        }

        //iniciando matriz com um espaço em todas posições
        for (x = 0; x < this.ambiente.length; x++) {
            for (y = 0; y < this.ambiente[x].length; y++) {
                this.ambiente[x][y]= "   ";
            }
        }

        //Adicionando Semaforo e desenho das ruas
        for (Agente semaforo1: this.agentes) {
            this.ambiente[semaforo1.getX()][semaforo1.getY()] = semaforo1.getDescricao();
            desenhaRua(semaforo1.getX(),semaforo1.getY());
        }


    }

    void desenhaRua(int xSemaforo,int ySemaforo){
        for (int x = 2; x < this.ambiente.length-2; x++) {
            for (int y = 2; y < this.ambiente[x].length-2; y++) {
                if (x == xSemaforo && (y-1 > ySemaforo || y+1 < ySemaforo)) {
                    this.ambiente[x+2][y] = " + ";
                    this.ambiente[x-2][y] = " + ";
                }
                if (y == ySemaforo && (x-1 > xSemaforo || x+1 < xSemaforo)) {
                    this.ambiente[x][y+2] = " + ";
                    this.ambiente[x][y-2] = " + ";
                }
            }
        }
    }

    public void imprimeAmbiente(){
        for (int x = 0; x < this.ambiente.length; x++) {
            for (int y = 0; y < this.ambiente[x].length; y++) {
                System.out.print(this.ambiente[x][y]);
            }
            System.out.println("");
        }
    }

    public void ambienteStart(){
        imprimeAmbiente();
    }
}
