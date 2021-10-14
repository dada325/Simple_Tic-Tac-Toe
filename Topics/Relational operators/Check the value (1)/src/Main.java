import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result<10&& result>0){
            System.out.println("true");
            // put your code here
        }else {
            System.out.println("false");
        }
    }
}