class CheckWin {
    // sT = scoreTable

    // check Horizontal
    boolean checkHorizontal (char[][] sT, char ch) {
        boolean winHor = false;
        for (int i = 0; i < 3; i++) {
            if (!winHor) {
                winHor = winHor || ((sT[i][0] == ch) && (sT[i][1] == ch) && (sT[i][2] == ch));
            }
            else break;
        }
        return winHor;
    }

    // check Vertical
    boolean checkVertical (char[][] sT, char ch) {
        boolean winVer = false;
        for (int i = 0; i < 3; i++) {
            if (!winVer) {
                winVer = winVer || ((sT[0][i] == ch) && (sT[1][i] == ch) && (sT[2][i] == ch));
            }
            else break;
        }
        return winVer;
    }
    // check Diagonal
    boolean checkDiagonal (char[][] sT, char ch) {
        // why make it linear?
        return ((sT[0][0] == ch) && (sT[1][1] == ch) && (sT[2][2] == ch));
    }

    // check Reverse Diagonal
    boolean checkRevDiagonal (char[][] sT, char ch) {
        return ((sT[0][2] == ch) && (sT[1][1] == ch) && (sT[2][0] == ch));
    }
}

class CheckWinner extends CheckWin {

    static boolean someoneWon = false;
    private static byte boxFilled = 0;
    String Player1, Player2;

    // Set PlayerName

    // public void setPlayers(String Player1, String Player2) {
    //     this.Player1 = Player1;
    //     this.Player2 = Player2;
    // }

    boolean p1Try (char[][] sT) {
        return (super.checkDiagonal(sT, 'X') || super.checkRevDiagonal(sT, 'X') || super.checkVertical(sT, 'X') || super.checkHorizontal(sT, 'X'));
    }
    boolean p2Try (char[][] sT) {
        return (super.checkDiagonal(sT, 'O') || super.checkRevDiagonal(sT, 'O') || super.checkVertical(sT, 'O') || super.checkHorizontal(sT, 'O'));
    }

    String winner (char[][] sT) {
        boxFilled++;
        boolean p1Try = p1Try(sT);
        boolean p2Try = p2Try(sT);
        if (p1Try && !(p2Try)) {
            CheckWinner.someoneWon = true;
            return this.Player1 + " Wins!!";
        }
        if (p2Try && !(p1Try)) {
            CheckWinner.someoneWon = true;
            return this.Player2 + " Wins!!";
        }
        return ((!someoneWon) && (boxFilled == 9)) ? "Match Tied. No Winner!!" : "Go On.";
    }



}
