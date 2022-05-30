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
        if( this.array == null ){
            throw new ArithmeticException("Array is null");
        }
        if( this.array.length == 0 ){
            throw new ArithmeticException("Array is empty");
        }
        if( this.array.length > 1000){
            throw new ArithmeticException("Array lenght is bigger than 1000");
        }
        return Arrays.stream(array).sum();
    }
}
