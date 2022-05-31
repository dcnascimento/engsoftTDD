import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Daniel Nascimento & Jefferson Cordeiro
 * @since 31/05/2022
 *
 */

@ExtendWith(MockitoExtension.class)
public class PalindromoTest {

    @Mock
    private Palindromo palindromo;

    @BeforeEach
    void init (){
        palindromo = new Palindromo();
    }

    @Test
    @DisplayName("Deve retornar verdadeiro quando a string for um palíndromo sem espaços")
    void mustReturnTrueWhenStringIsAPalindromeWithoutBlankSpace(){
        //given
        String expressao = "arara";

        //when
        boolean result = palindromo.isPalindromo(expressao);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro quando a string for um palíndromo com espaços")
    void mustReturnTrueWhenStringIsAPalindromeWithBlankSpace(){
        //given
        String expressao = "ame o poema";

        //when
        boolean result = palindromo.isPalindromo(expressao);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro quando a string for um palíndromo com caracteres especiais")
    void mustReturnTrueWhenStringIsAPalindromeWithSpecialCharacters(){
        //given
        String expressao = "adias a data da saída";

        //when
        boolean result = palindromo.isPalindromo(expressao);

        //then
        assertTrue(result);
    }
    
    @Test
    @DisplayName("Deve retornar verdadeiro quando a string for um palíndromo independentemente do case")
    void mustReturnTrueWhenStringIsAPalindromeIgnoreCase(){
        //given
        String expressao = "Socorram-me, subi no ônibus em Marrocos";

        //when
        boolean result = palindromo.isPalindromo(expressao);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar falso quando a string não for um palíndromo")
    void mustReturnFalseWhenStringIsNotAPalindrome(){
        //given
        String expressao = "palíndromo";

        //when
        boolean result = palindromo.isPalindromo(expressao);

        //then
        assertFalse(result);
    }

}
