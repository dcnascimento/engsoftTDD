import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author Daniel Nascimento
 * @since 31/05/2022
 */
public class Palindromo {

    private String invertida;

    public Palindromo() {
    }

    public boolean isPalindromo(String palavra){
        palavra = normalizeWord(palavra);
        setInvertida(palavra);
        return palavra.equals(new StringBuffer(getInvertida()).reverse().toString());
    }

    private String normalizeWord(String palavra) {
        String normalized = Normalizer.normalize(palavra, Normalizer.Form.NFD)
                .replaceAll("\\s+","")
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }

    public String getInvertida() {
        return invertida;
    }

    public void setInvertida(String invertida) {
        this.invertida = invertida;
    }
}
