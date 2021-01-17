package ru.geekbrains;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = size;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public Array(boolean isSorted, int... args) {
        this(args);
        this.isSorted = isSorted;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
        arr[index] = value;
        isSorted = false;
    }

    public boolean delete() { // last
        if (size == 0) return false;
        size--;
        return true;
    }

    public boolean delete(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);

        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    public void append(int value) {
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    public boolean isInArray(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Trying to search in unsorted array");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1;
            if (value == arr[m]) {
                return m;
            } else {
                if (value < arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() {
        int count = 0;
        for (int out = size - 1; out > 0; out--) {
            boolean sorted = true;
            for (int in = 0; in < out; in++) {
                count++;
                if (this.arr[in] > arr[in + 1]) {
                    swap(in, in + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        isSorted = true;
        System.out.println("sortBubble count: " + count + ", n = " + size);
    }

    public void sortSelect() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int flag = i;
            for (int j = i + 1; j < size; j++) {
                count++;
                if (arr[j] < arr[flag])
                    flag = j;
            }
            swap(i, flag);
        }
        isSorted = true;
        System.out.println("sortSelect count: " + count + ", n = " + size);
    }

    public void sortInsert() {
        int count = 0;
        for (int out = 1; out < size; out++) {
            int temp = arr[out];
            int in = out;
            count++;
            while (in > 0 && arr[in - 1] >= temp) {
                count++;
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
        System.out.println("sortInsert count: " + count + ", n = " + size);
    }

    public boolean deleteAll(int value) {
        if (this.isSorted) {
            return this.deleteAllSorted(value);
        } else {
            boolean res = false;
            int shift = 0;
            for (int i = 0; i < size; i++) {
                if (this.arr[i] == value) {
                    res = true;
                    shift++;
                } else {
                    this.arr[i - shift] = this.arr[i];
                }
            }
            size = size - shift;
            return res;
        }
    }

    public boolean deleteAllSorted(int value) {
        int i = this.hasValue(value);
        if (i == -1) {
            return false;
        } else {
            int iMin = i;
            int iMax = i;
            while ((iMin - 1) >= 0 && this.arr[iMin - 1] == value) {
                iMin = iMin - 1;
            }
            while ((iMax + 1) < size && this.arr[iMax + 1] == value) {
                iMax = iMax + 1;
            }
            System.arraycopy(arr, iMax + 1, arr, iMin, size - iMax - 1);
            size = size - (iMax - iMin) - 1;
        }
        return true;
    }

    public boolean deleteAll() {
        if (this.size == 0) {
            return false;
        }
        this.size = 0;
        this.arr = new int[0];
        return true;
    }

    public void insert(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, index);
            System.arraycopy(temp, index, arr, index + 1, size - index);
            size++;
            arr[index] = value;
        } else {
            System.arraycopy(arr, index, arr, index + 1, size - index);
            size++;
            arr[index] = value;
        }
    }

    //* Реализовать сортировку подсчётом
    public void sortCount(int min, int max) {
        int[] arrCount = new int[max - min + 1];
        for (int i = 0; i < size; i++) {
            arrCount[arr[i] - min]++;
        }
        int shift = 0;
        for (int i = 0; i < arrCount.length; i++) {
            for (int k = shift; k < shift + arrCount[i]; k++) {
                arr[k] = i + min;
            }
            shift = shift + arrCount[i];
        }
    }

    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
