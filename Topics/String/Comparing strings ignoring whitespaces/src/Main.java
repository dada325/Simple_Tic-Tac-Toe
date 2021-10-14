import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String a = myScanner.nextLine().trim().replaceAll("\\s","");
        String b = myScanner.nextLine().trim().replaceAll("\\s","");
       if (a.equals(b)){
           System.out.println("true");
       }
       else{
           System.out.println("false");
       }
    }
}