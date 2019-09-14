package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Ambiente {

    private String ambiente[][];
    private ArrayList<Agente> agentes;

    public Ambiente() {
        this.agentes = new ArrayList<Agente>();
        this.ambiente= new String[20][20];
        geraAmbiente();
    }

    // gera o ambiente inicial
    public void geraAmbiente(){
        Random random = new Random();
        Semaforo semaforo;

        int qtd_cruzamento = random.nextInt(3);
        if (qtd_cruzamento==0) qtd_cruzamento++;

        //iniciando matriz com um espaço em todas posições
        for (int x = 0; x < ambiente.length; x++) {
            for (int y = 0; y < ambiente[x].length; y++) {
                ambiente[x][y]=" ";
            }
        }

        //gera os agentes semaforos, que ficarão no centro dos cruzamentos
        for (int i = 0; i < qtd_cruzamento; i++) {
            semaforo = new Semaforo(random.nextInt(20),random.nextInt(20),"S");
            this.agentes.add(semaforo);
        }

        //
        for (Agente semaforo1: this.agentes) {
            this.ambiente[semaforo1.getX()][semaforo1.getY()] = semaforo1.getDescricao();
        }

    }

    public void imprimeAmbiente(){
        for (int x = 0; x < ambiente.length; x++) {
            for (int y = 0; y < ambiente[x].length; y++) {
                System.out.print(ambiente[x][y]);
            }
            System.out.println("");
        }
    }

    public void ambienteStart(){
        imprimeAmbiente();
    }
}
