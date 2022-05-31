import java.util.Arrays;

/**
 * @author Daniel Nascimento
 * @since 30/05/2022
 */
public class DiferencaDiagonal {

    private int[][] matrix;

    private int diagonalEsquerda;

    private int diagonalDireita;

    public DiferencaDiagonal() {
    }

    public int calculaDiferencaDiagonal() {

        if(matrix == null || matrix.length == 0){
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        if(matrix.length > 1000){
            throw new IllegalArgumentException("Matrix maximum size exceed. Limit is 1000");
        }

        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < this.matrix.length; j++)
            {
                if (i == j)
                    this.diagonalEsquerda += matrix[i][j];

                if (i == matrix.length - j - 1)
                    this.diagonalDireita += matrix[i][j];
            }
        }
        return Math.abs(getDiagonalEsquerda() - getDiagonalDireita());
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getDiagonalEsquerda() {
        return diagonalEsquerda;
    }

    public int getDiagonalDireita() {
        return diagonalDireita;
    }

}
