package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------\n|       |\n|       |\n|       |\n---------\n");
        String a = "         ";
        int counter = 0;
        while(true){

            if(!printResult(a).equals("cont")){
                break;
            }
            a = assertMove(a,counter);
            printGame(a);
            counter++;
        }


    }

    // the func to print the board
    public static void printGame (String a){
        char a1 = a.charAt(0);
        char a2 = a.charAt(1);
        char a3 = a.charAt(2);
        char a4 = a.charAt(3);
        char a5 = a.charAt(4);
        char a6 = a.charAt(5);
        char a7 = a.charAt(6);
        char a8 = a.charAt(7);
        char a9 = a.charAt(8);

        System.out.format("---------\n| %c %c %c |\n| %c %c %c |\n| %c %c %c |\n---------\n",a1,a2,a3,a4,a5,a6,a7,a8,a9);

    }
    // the func to analysis the board result
    public static String printResult (String a){
        char[] ax = a.toCharArray();
        int sumX=0, sumO=0; //initialize the sum of X and O on the board
        String xWing = "XXX";
        String oWing = "OOO";
        boolean containSpace = true;
        boolean xHas3 = false,oHas3 = false;

        // iterate the char array to sum up sumX and sumO
        for (char c : ax) {

            if (c == 'X') {
                sumX += 1;
            } else if (c == 'O') {
                sumO += 1;
            }
        }

        int countSpace = 0;

        // iterate to check if there is space
        for (char c : ax) {
            if (c == ' '){
                countSpace += 1;
            }
        }
        if (countSpace == 0){
            containSpace = false;
        } else {
            containSpace = true;
        }


        boolean xDiag = false, oDiag =false, xVerti = false, oVerti = false;
        //check if on the diagonal line X wins
        if ((ax[0] == 'X' && ax[4] == 'X' && ax[8] == 'X') || (ax[2] == 'X' && ax[4] == 'X' &&ax[6] == 'X' )){
            xDiag = true;
        }
        //check if on the diagonal line O wins
        if ((ax[0] == 'O' && ax[4] == 'O' && ax[8] == 'O') || (ax[2] == 'O' && ax[4] == 'O' &&ax[6] == 'O' )){
            oDiag = true;
        }
        //check if on the vertical line X wins
        if ((ax[0] == 'X' && ax[3] == 'X' && ax[6] == 'X') || (ax[1] == 'X' && ax[4] == 'X' && ax[7] == 'X' )|| (ax[2] == 'X' && ax[5] == 'X' &&ax[8] == 'X'))
            {
            xVerti = true;
            }
        //check if on the vertical line O wins
        if ((ax[0] == 'O' && ax[3] == 'O' && ax[6] == 'O') || (ax[1] == 'O' && ax[4] == 'O' &&ax[7] == 'O' )|| (ax[2] == 'O' && ax[5] == 'O' &&ax[8] == 'O'))
            {
            oVerti = true;
            }
        // check if X has 3 in a line on the board
        if (a.substring(0,3).equals(xWing) ||  a.substring(3,6).equals(xWing) || (ax[6] == 'X' && ax[7] == 'X' && ax[8] == 'X') || xDiag || xVerti){
            xHas3 = true;
        }
        // check if O has 3 in a line on the board
        if (a.substring(0,3).equals(oWing) ||  a.substring(3,6).equals(oWing) ||  (ax[6] == 'O' && ax[7] == 'O' && ax[8] == 'O') || oDiag || oVerti){
            oHas3 = true;
        }

        //the logic to assert the result:
        if ( Math.abs(sumX - sumO) >= 2 || (xHas3 && oHas3)) {
            System.out.println("Impossible");
            return "impossible";
        } else if (xHas3){
            System.out.println("X wins");
            return "X";
        } else if (oHas3) {
            System.out.println("O wins");
            return "O";
        } else if (containSpace){
            return "cont";
        } else {
            System.out.println("Draw");
            return"Draw";
        }


    }

    public static String assertMove (String a, int counter){
        String coordinateCombi="11";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the coordinates:");
        String coords = myScanner.nextLine().replaceAll("\\s+","");

        while (true) {

            if (isNumeric(coords)) {

                char[] coordsO = coords.toCharArray();
                String coords1 = Character.toString(coordsO[0]);
                String coords2 = Character.toString(coordsO[1]);

                int coordsDigi1 = Integer.parseInt(coords1);
                int coordsDigi2 = Integer.parseInt(coords2);

                while (true){
                    if (coordsDigi1>0 && coordsDigi1<4 && coordsDigi2 <4 && coordsDigi2>0) {
                        coordinateCombi =coords1+coords2;

                        HashMap <String,Integer> coordinates = new HashMap<>();
                        coordinates.put("11",0);
                        coordinates.put("12",1);
                        coordinates.put("13",2);
                        coordinates.put("21",3);
                        coordinates.put("22",4);
                        coordinates.put("23",5);
                        coordinates.put("31",6);
                        coordinates.put("32",7);
                        coordinates.put("33",8);

                        //translate to the linear place
                        int placeToMove = coordinates.get(coordinateCombi);

                        // iterate to check if there is space
                        Set<Integer> movePlace = new HashSet<>();
                        for (int i=0; i< a.length(); i++) {
                            if (a.charAt(i) == ' '){
                                movePlace.add(i);
                            }
                        }

                        while (true){
                            if (movePlace.contains(placeToMove)){
                                if(counter%2 == 0){
                                    return makeTheMove(placeToMove,a);
                                }
                                else return makeTheMoveO(placeToMove,a);
                            }
                            System.out.println("This cell is occupied! Choose another one!");
                            break;
                        }
                    }
                    System.out.println("Coordinates should be from 1 to 3!");
                    break;

                }


            }
            System.out.println("You should enter numbers!");
            System.out.println("Enter the coordinates:");
            coords = myScanner.nextLine().replaceAll("\\s+","");
        }



    }

    public static String makeTheMove(int placeToMove, String a){
        char[] ax = a.toCharArray();
        ax[placeToMove] = 'X';
        return  String.valueOf(ax);
    }

    public static String makeTheMoveO(int placeToMove, String a){
        char[] ax = a.toCharArray();
        ax[placeToMove] = 'O';
        return  String.valueOf(ax);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}


