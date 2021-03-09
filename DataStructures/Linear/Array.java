package DataStructure.Linear;

public class Array {
    private int[] items;
    private int count = 0;

    public Array(int length) {
        if (length < 0)
            throw new IllegalArgumentException();

        items = new int[length];
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeArray();
        if (count - index >= 0)
            System.arraycopy(items, index, items, index + 1, count - index);

        items[index] = item;
        count++;

    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }

    public int max() {
        int max = 0;
        for (int item : items) {
            if (item > max)
                max = item;
        }

        return max;
    }

    public void insert(int item) {
        resizeArray();

        items[count] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        else {
            int[] newItems = new int[items.length];
            resizeArray();
            for (int i = 0; i < count; i++) {
                if (i >= index)
                    newItems[i] = items[i + 1];
                else
                    newItems[i] = items[i];
            }

            items = newItems;
            count--;
        }
    }

    public void print() {
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i == count - 1)
                array.append(items[i]);
            else
                array.append(items[i]).append(", ");
        }

        System.out.println("[" + array + "]");
    }

    public int indexOf(int index) {
        if (index > items.length || index < 0)
            return -1;
        else {
            for (int i = 0; i < count; i++) {
                if (index == items[i])
                    return i;
            }
        }

        return -1;
    }

    private void resizeArray() {
        if (count >= items.length) {
            int[] newItems = new int[items.length + 1];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
    }
}
