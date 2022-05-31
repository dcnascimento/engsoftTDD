import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Daniel Nascimento & Jefferson Cordeiro
 * @since 30/05/2022
 *
 */

@ExtendWith(MockitoExtension.class)
public class DiferencaDiagonalTest {

    @Mock
    private DiferencaDiagonal diferencaDiagonal;

    @BeforeEach
    void init(){
        diferencaDiagonal = new DiferencaDiagonal();
    }

    @Test
    @DisplayName("Deve retornar a diferença diagonal quando a matriz não estiver vazia")
    void mustReturnTheResultWhenMatrixIsNotEmpty(){
        //given
        diferencaDiagonal.setMatriz(new int[][]{
                {1, 2 ,3},
                {4, 5, 6},
                {9, 8, 9}
        });

        //when
        int result = diferencaDiagonal.calculaDiferencaDiagonal();

        //then
        assertEquals(2, result);

    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz estiver vazia")
    void mustThrowExceptionWhenMatrixIsEmpty(){
        //given
        diferencaDiagonal.setMatriz(new int[][]{});

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Matrix cannot be null or empty", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz for nula")
    void mustThrowExceptionWhenMatrixIsNull(){
        //given

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Matrix cannot be null or empty", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz possuir mais de 1000 colunas")
    void mustThrowExceptionWhenMatrixHasMoreThanThousandColumns(){
        //given
        diferencaDiagonal.setMatriz(new int[1001][]);

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Matrix maximum size exceed. Limit is 1000", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz não for diagonalizável")
    void mustThrowExceptionWhenMatrixIsNotDiagonalizable(){
        //given
        diferencaDiagonal.setMatriz(new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {6, 7, 8, 9},
        });

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Matrix must be diagonalizable", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz possuir elemento com valor acima de 100")
    void mustThrowExceptionWhenMatrixElementHasValueAboveHundred(){
        //given
        diferencaDiagonal.setMatriz(new int[][]{
                {10, 20, 30},
                {400, 50, 6},
                {7, 82, 90},
        });

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Values must be between -100 and 100", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a matriz possuir elemento com valor abaixo de -100")
    void mustThrowExceptionWhenMatrixElementHasValueBelowMinusHundred(){
        //given
        diferencaDiagonal.setMatriz(new int[][]{
                {-101, 20, 30},
                {40, 50, 6},
                {7, 82, 90},
        });

        //when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> diferencaDiagonal.calculaDiferencaDiagonal());

        //then
        assertEquals("Values must be between -100 and 100", thrown.getMessage());
    }

}
