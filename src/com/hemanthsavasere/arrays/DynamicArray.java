public class DynamicArray<T> {

    private T[] array;
    private int length;
    private int size;

    DynamicArray() {
        this.size = 2;
        this.length = 0;
        array = (T[]) new Object[size];
    }

    public static void main(String[] args) throws Exception {
        DynamicArray<Integer> arr = new DynamicArray<>();
        System.out.println(arr);
        arr.add(0, 0);
        arr.add(10);
        arr.add(15);
        arr.add(30);
        arr.delete(0);
        arr.delete(2);
        arr.add(2, 20);
        arr.add(60);
        arr.add(70);
        arr.add(80);
        arr.add(90);
        arr.add(5, 1002);

        System.out.println(arr);
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > length)
            throw new Exception("index of array out of bound");
        return array[index];
    }

    public int search(T element) {
        for (int i = 0; i < length; i++) {
            if (element == array[i])
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void add(T element) {
        length += 1;
        if (length > size) {
            size *= 2;
            T[] tempArray = (T[]) new Object[size];
            for (int i = 0; i < length - 1; i++) {
                tempArray[i] = array[i];
            }
            tempArray[length - 1] = element;
            array = tempArray;
        } else {
            array[length - 1] = element;
        }
    }

    public void delete(int index) throws Exception {
        if (index > length || index < 0)
            throw new Exception("index is not valid");
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        length -= 1;
    }

    public void add(int index, T element) throws Exception {
        if (index > length || index < 0)
            throw new Exception("index is not valid");

        length += 1;
        if (length > size) {
            size *= 2;
            T[] tempArray = (T[]) new Object[size];
            for (int i = 0; i < index; i++) {
                tempArray[i] = array[i];
            }
            tempArray[index] = element;
            for (int i = index; i < length - 1; i++) {
                tempArray[i + 1] = array[i];
            }
            array = tempArray;
        } else {
            for (int i = length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
        }
    }
}
