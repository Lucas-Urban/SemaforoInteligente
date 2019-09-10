public class AgenteMovel  {
    private int x;
    private int y;

    public AgenteMovel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void andar(int xMov, int yMov){
        this.x+= xMov;
        this.y+= yMov;
    }
    public void ler(){
        
    }

}