
package trabalho_6;


class Node {

    private int vezes;
    private char letra;

    public Node(char letra, int vezes) {
        this.vezes = vezes;
        this.letra = letra;
    }

    public Node() {
    }

    public int getVezes() {
        return vezes;
    }

    public void setVezes(int vezes) {
        this.vezes = vezes;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }


    
    public String toString() {
        return "A palavra " + letra + " ocorre " + vezes + " vezes.";
    }
}
