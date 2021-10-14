import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] boyHeight = new int[3];
        boyHeight[0] = scanner.nextInt();
        boyHeight[1] = scanner.nextInt();
        boyHeight[2] = scanner.nextInt();

        if (isSortedL(boyHeight) || isSortedH(boyHeight)){
            System.out.println("true");

        } else {
            System.out.println("false");
        }

        // put your code here
    }

    public static boolean isSortedL(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static boolean isSortedH(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }

}

