public class AgenteMovel extends Agente {

    public AgenteMovel(int x, int y, String descricao) {
        super(x, y, descricao);
    }

    public void movimentar(int xMov, int yMov){
        this.setX(this.getX()+xMov);
        this.setY(this.getY()+yMov);
    }
}