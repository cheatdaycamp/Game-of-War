package wargame02;

import java.util.Scanner;
import java.util.*;

public class WarGame02 {

    public static void WelcomeScreen(String[] args) { //Welcome Screen
//welcome screen with some cool Deff Leppard typography       
        System.out.println("                           ,;                  .,    t#,                                 ,;                t#,                                                ");
        System.out.println("                         f#i            i     ,Wt   ;##W.                              f#i                ;##W.                                    j.         ");
        System.out.println("           ;           .E#t            LE    i#D.  :#L:WE             ..       :     .E#t     GEEEEEEEL  :#L:WE                ;                .. EW,        ");
        System.out.println("         .DL          i#W,            L#E   f#f   .KG  ,#D           ,W,     .Et    i#W,      ,;;L#K;;. .KG  ,#D             .DL               ;W, E##j       ");
        System.out.println(" f.     :K#L     LWL L#D.            G#W. .D#i    EE    ;#f         t##,    ,W#t   L#D.          t#E    EE    ;#f    f.     :K#L     LWL      j##, E###D.     ");
        System.out.println(" EW:   ;W##L   .E#f:K#Wfff;         D#K. :KW,    f#.     t#i       L###,   j###t :K#Wfff;        t#E   f#.     t#i   EW:   ;W##L   .E#f      G###, E#jG#W;    ");
        System.out.println(" E#t  t#KE#L  ,W#; i##WLLLLt       E#K.  t#f     :#G     GK      .E#j##,  G#fE#t i##WLLLLt       t#E   :#G     GK    E#t  t#KE#L  ,W#;     :E####, E#t t##f   ");
        System.out.println(" E#t f#D.L#L t#K:   .E#L         .E#E.    ;#G     ;#L   LW.     ;WW; ##,:K#i E#t  .E#L           t#E    ;#L   LW.    E#t f#D.L#L t#K:     ;W#DG##, E#t  :K#E: ");
        System.out.println(" E#jG#f  L#LL#G       f#E:      .K#E       :KE.    t#f f#:     j#E.  ##f#W,  E#t    f#E:         t#E     t#f f#:     E#jG#f  L#LL#G      j###DW##, E#KDDDD###i");
        System.out.println(" E###;   L###j         ,WW;    .K#D         .DW:    f#D#;    .D#L    ###K:   E#t     ,WW;        t#E      f#D#;      E###;   L###j      G##i,,G##, E#f,t#Wi,,,");
        System.out.println(" E#K:    L#W;           .D#;  .W#G            L#,    G#t    :K#t     ##D.    E#t      .D#;       t#E       G#t       E#K:    L#W;     :K#K:   L##, E#t  ;#W:  ");
        System.out.println(" EG      LE.              tt :W##########Wt    jt     t     ...      #G      ..         tt        fE        t        EG      LE.     ;##D.    L##, DWi   ,KK: ");
        System.out.println(" ;       ;@                  :,,,,,,,,,,,,,.                         j                             :                 ;       ;@      ,,,      .,,             ");

    }

    public static void Intro(String[] args) {    //explains the game
        System.out.println("\nThe game of war is a basic game.");
        System.out.println("The rules are simple: each player draws a card. The player with the higher card wins the round.");
        System.out.println("You can play as many rounds as you can.... As long as you have the money for it, of course...");
    }

    public static void main(String[] args) {
        WarGame02.WelcomeScreen(args);
        WarGame02.Intro(args);

        int balance = 50; // credit for the user
        boolean userwantstoplay = true;
        int maxbet = balance; //comparison between the number user wants to bet with his credit
        int userinput; //the user bet
        String name; //username

        //getting the name
        System.out.println("\nPlease enter your name and hit Enter");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        while (name.equals("")) {
            System.out.println("I said... Please enter your name and hit enter!!!!");
            name = scan.nextLine();
        }

        System.out.println("\nHello " + name + "! You currently have " + balance + " dollars");
        while ((balance > 0) & (userwantstoplay = true)) {

            System.out.println("Place your bet for the next round: 1 to " + maxbet + "\n");
            Scanner scan2 = new Scanner(System.in);
            while (!scan2.hasNextInt()) {
                System.out.println("Please insert a bet");
                scan2.next();
            }
            userinput = scan2.nextInt();
            if (userinput >= 1 & userinput <= maxbet) {
                //System.out.println("Nice Bet");
            } else {
                System.out.println("I said between 1 to " + maxbet + " And you typed " + userinput);
                System.out.println("I don't play with liars!!! Bye");
                //Thread.sleep(5000); //giving some time to read before closing
                System.exit(0);
                scan2.nextInt();
            }
            //shuffling 12 cards and considering 3 scenarios: win, loose, draw.
            int[] cards = new int[12];
            Random generator = new Random();
            int usercard = generator.nextInt(cards.length);
            int pccard = generator.nextInt(cards.length);
            System.out.println("Your Card is " + usercard + " And my Card is " + pccard);
            {
                if (usercard > pccard) {
                    balance = balance + userinput;
                    System.out.println("You won " + userinput + " And now you have " + balance);
                } else if (usercard == pccard) {
                    System.out.println("It is a draw. You still have " + balance);
                } else {
                    balance = balance - userinput;
                    System.out.println("You lost " + userinput + " And now you have " + balance);
                }

            }

            //checking what happens with the balance
            {
                if (balance <= 0) {
                    System.out.println("You are broke... Bye Bye");
                    //TimeUnit.SECONDS.sleep(3); //giving some time to read before closing
                    System.exit(0);
                } else {
                    System.out.println("What would you like to do?");
                    System.out.println("1. Play another round");
                    System.out.println("2. Leave with my Money");
                }

                String playag = scan.nextLine();

                while (!(playag.equals("1") | playag.equals("2"))) {
                    System.out.println("Please insert an option: 1 or 2 and then hit Enter");
                    playag = scan.nextLine();
                }
                {
                    if ("2".equals(playag)) {
                        System.exit(0);
                    } else {
                        maxbet = balance;
                    }

                }
            }

        }
    }
}
