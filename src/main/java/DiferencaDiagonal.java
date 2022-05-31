/**
 * @author Daniel Nascimento & Jefferson Cordeiro
 * @since 30/05/2022
 */
public class DiferencaDiagonal {

    private int[][] matriz;

    private int diagonalEsquerda;

    private int diagonalDireita;

    public DiferencaDiagonal() {
    }

    public int calculaDiferencaDiagonal() {
        verificaMatriz();
        calculaDiagonais();
        return Math.abs(getDiagonalEsquerda() - getDiagonalDireita());
    }

    private void verificaMatriz() {
        if(matriz == null || matriz.length == 0){
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        if(matriz.length > 1000){
            throw new IllegalArgumentException("Matrix maximum size exceed. Limit is 1000");
        }

        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i].length != matriz.length){
                throw new IllegalArgumentException("Matrix must be diagonalizable");
            }
        }
    }

    private void calculaDiagonais() {
        for (int i = 0; i < this.matriz.length; i++)
        {
            for (int j = 0; j < this.matriz.length; j++)
            {
                if (i == j)
                    this.diagonalEsquerda += matriz[i][j];

                if (i == matriz.length - j - 1)
                    this.diagonalDireita += matriz[i][j];
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getDiagonalEsquerda() {
        return diagonalEsquerda;
    }

    public int getDiagonalDireita() {
        return diagonalDireita;
    }

}
