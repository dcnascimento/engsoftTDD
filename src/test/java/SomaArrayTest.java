import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Daniel Nascimento & Jefferson Cordeiro
 * @since 30/05/2022
 *
 */

@ExtendWith(MockitoExtension.class)
public class SomaArrayTest {

    @Mock
    private SomaArray somaArray;

    @BeforeEach
    void init(){
        somaArray = new SomaArray();
    }

    @Test
    @DisplayName("Deve somar os valores do array quando não estiver vazio")
    void mustSumWhenArrayIsNotEmpty(){
        //given
        somaArray.setArray(new int[]{1,2,3});

        //when
        somaArray.sum();

        //then
        assertEquals(9, 9);

    }

    @Test
    @DisplayName("Deve recusar a soma quando array estiver vazio")
    void mustReturnZeroWhenArrayIsEmpty(){
        //given
        somaArray.setArray(new int[]{});

        //when
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> somaArray.sum());

        //then
        assertEquals("Array is empty", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve recusar a soma o array for nulo")
    void mustReturnZeroWhenArrayIsNull(){
        //given

        //when
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> somaArray.sum());

        //then
        assertEquals("Array is null", thrown.getMessage());
    }

    @Test
    @DisplayName("Deve recusar a soma caso o array possua mais de mil elementos")
    void mustNotSumWhenArrayContainsMoreThanThousandElements(){
        //given
        somaArray.setArray(new int[1001]);

        //when
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> somaArray.sum());

        //then
        assertEquals("Array lenght is bigger than 1000", thrown.getMessage());
    }
}
