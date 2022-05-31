import java.util.Arrays;

/**
 * @author Daniel Nascimento & Jefferson Cordeiro
 * @since 30/05/2022
 */
public class SomaArray {

    private int[] array;

    public SomaArray() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int sum(){
        verificaArray();
        return Arrays.stream(array).sum();
    }

    private void verificaArray() {
        if( this.array == null || this.array.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if( this.array.length > 1000){
            throw new IllegalArgumentException("Array maximum size exceed. Limit is 1000");
        }
    }
}
