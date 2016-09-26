package laurentesp.test;

import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nouvelString = "Laval";
        String stringEnvers = envers(nouvelString);


        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(nouvelString);
        //textView.setText("Bonjour!");

        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setText(stringEnvers);

        TextView textView3 = (TextView) findViewById(R.id.text3);
        if (isPalindrome(nouvelString)) {
            textView3.setText("Ce mot est un palindrome");
        } else {
            textView3.setText("Ce mot n'est pas un palindrome");
        }

        String stringPhraseEspace = "       ceci est un     test ";

        TextView textView4 = (TextView) findViewById(R.id.text4);
        textView4.setText(stringPhraseEspace);

        TextView textView5 = (TextView) findViewById(R.id.text5);
        textView5.setText(corrigeTexte(stringPhraseEspace));

        TextView textView6 = (TextView) findViewById(R.id.text6);
        textView6.setText(stringPhraseEspace.trim().replaceAll("\\s+", " "));

        String premierStringBracket = "((toto)())";

        TextView textView7 = (TextView) findViewById(R.id.text7);
        textView7.setText(premierStringBracket);

        TextView textView8 = (TextView) findViewById(R.id.text8);
        if (checkBrackets(premierStringBracket)) {
            textView8.setText("Ok");
        } else {
            textView8.setText("NOk");
        }

        String stringPhraseEnvers = "les lapins bleus ont mangé toutes les carottes";
        TextView textView9 = (TextView) findViewById(R.id.text9);
        textView9.setText(fibonacciSuite(15));
        TextView textView10 = (TextView) findViewById(R.id.text10);


        List<String> stringList = new ArrayList<>();
        stringList.add("une chaîne");
        stringList.set(0, "abcde");

        Map<String, Object> map = new HashMap<>();
        map.put("Noel", new Date("25 dec 2014"));
        map.put("une collection", new ArrayList<StringBuffer>());

        StringBuffer cleHasmap = new StringBuffer("");
        for (String key : map.keySet()) {
            cleHasmap.append("à la clé " + key + " est associé " + map.get(key).toString());
        }
        textView10.setText(cleHasmap);

        Intervalle i1 = new Intervalle(0,5);
        Intervalle i2 = new Intervalle(10,25);

        TextView textView11 = (TextView) findViewById(R.id.text11);
        TextView textView12 = (TextView) findViewById(R.id.text12);
        TextView textView13 = (TextView) findViewById(R.id.text13);
        TextView textView14 = (TextView) findViewById(R.id.text14);
        textView11.setText("i1 =" + i1);
        textView12.setText("i2 =" + i2);
        try {
            textView13.setText("i1.intersection(i2) =" + i1.intersection(i2));
            textView14.setText("i1.union(i2) =" + i1.union(i2));
        } catch (IllegalArgumentException e){
            textView13.setText("Intervalles disjoints : " + i1 + " et "+ i2);
            textView14.setText("Intervalles disjoints : " + i1 + " et "+ i2);
        }



        Square monCarre = new Square(5);
        TextView textView15 = (TextView) findViewById(R.id.text15);
        textView15.setText("Mon carre a une superficie de " + monCarre.getArea());

        Rectangle monRec = new Rectangle(5,4);
        TextView textView16 = (TextView) findViewById(R.id.text16);
        textView16.setText("Mon rectangle a une superficie de " + monRec.getArea());

        monCarre.zoomx2();
        monCarre.computeArea();
        TextView textView17 = (TextView) findViewById(R.id.text17);
        textView17.setText("Mon carre a une nouvelle superficie de " + monCarre.getArea());
    }

    private String envers(String mot) {
        StringBuffer motEnvers = new StringBuffer("");
        int longueurMot = mot.length();
        for (int i = longueurMot; i > 0; i--) {
            motEnvers.append(mot.charAt(i - 1));
        }
        return motEnvers.toString();
    }

    private boolean isPalindrome(String mot) {
        int longueurMot = mot.length();
        boolean palindromeResult = false;
        for (int i = 0; i < longueurMot / 2; i++) {
            if (Character.toLowerCase(mot.charAt(i)) == Character.toLowerCase(mot.charAt(longueurMot - i - 1))) {
                palindromeResult = true;
            } else {
                palindromeResult = false;
                break;
            }
        }
        return palindromeResult;
    }

    private String corrigeTexte(String mot) {
        int maxIndex = mot.length();
        boolean premierCarNonEspaceTrouve = false;
        StringBuffer nouvelleString = new StringBuffer("");
        for (int indexMot = 0; indexMot < maxIndex; indexMot++) {
            // Enleve les espaces en début et en fin de chaine
            if ((indexMot == 0) || (indexMot == maxIndex - 1)) {
                if (mot.charAt(indexMot) != ' ') {
                    nouvelleString.append(mot.charAt(indexMot));
                    premierCarNonEspaceTrouve = true;
                }
            } else {
                // Enleve les espaces consécutifs à l'intérieur de la chaine
                if ((mot.charAt(indexMot) == ' ') && (mot.charAt(indexMot + 1) == ' ')) {
                } else {
                    if (premierCarNonEspaceTrouve) {
                        nouvelleString.append(mot.charAt(indexMot));
                    } else {
                        if (mot.charAt(indexMot) != ' ') {
                            premierCarNonEspaceTrouve = true;
                            nouvelleString.append(mot.charAt(indexMot));
                        }
                    }
                }
            }
        }
        return nouvelleString.toString();
    }


    private boolean checkBrackets(String bracketsString) {
        int maxIndex = bracketsString.length();
        int valeurBracket = 0;
        boolean resultCheckString = false;
        for (int indexString = 0; indexString < maxIndex; indexString++) {
            //An opening bracket increments the counter
            if (bracketsString.charAt(indexString) == '(') {
                valeurBracket++;
            } else {
                // A closing bracket decrements the counter
                if (bracketsString.charAt(indexString) == ')') {
                    valeurBracket--;
                }
                // If too much closing brackets -> error so return false which will stop the program
                if (valeurBracket < 0) {
                    resultCheckString = false;
                    return false;
                } else {
                    resultCheckString = true;
                }
            }

        }
        // Check if there is too much opening brackets
        if (valeurBracket > 0) {
            resultCheckString = false;
        }
        return resultCheckString;
    }

    private String mixLettersInWords(String sentenceIn) {

        String sentenceInCorrige = corrigeTexte(sentenceIn);

        StringBuffer motIntermediaire = new StringBuffer("");
        StringBuffer motMelange = new StringBuffer("");
        StringBuffer phraseFinale = new StringBuffer("");
        int wordCounter = 0;
        char interChar = 0;
        int oldIndex = 0; // index of the last character in a word

        for (int indexSentence = 0; indexSentence < sentenceInCorrige.length(); indexSentence++) {

            if (sentenceInCorrige.charAt(indexSentence) == ' ') {
                motIntermediaire.append(sentenceInCorrige.substring(oldIndex, indexSentence - 1));
                Log.e("TestLog", motIntermediaire.toString());
                oldIndex = indexSentence + 1;
                wordCounter++;

                int wordLength = motIntermediaire.length();


                for (int indexMot = 0; indexMot < wordLength; indexMot++) {
                    int NewlongueurMotInter = motIntermediaire.length();
                    int indexRand = random(0, motIntermediaire.length());
                    motMelange.append(motIntermediaire.charAt(indexRand));
                    motIntermediaire.deleteCharAt(indexRand);
                }
                motMelange.append(' ');
            }

        }
        return motMelange.toString();
    }

    public static int random(int min, int max) {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        return nombreAleatoire;
    }

    private static String[] getWordsFrom(String text) {
        return text.split(" ");
    }


    private String fibonacciSuite(int nbIteration) {
        int sumVal = 1;
        int sumValOld = 0;
        int inter = 0;
        StringBuffer fiboString = new StringBuffer("1 ");
        for (int i = 0; i < nbIteration - 1; i++) {
            inter = sumVal;
            sumVal = sumVal + sumValOld;
            sumValOld = inter;
            fiboString.append(sumVal + " ");
        }
        return fiboString.toString();
    }


 /*   private String fibonacciRec(int old, int cur, int iter) {
        StringBuffer fiboString = new StringBuffer("");
        if (iter == 0) {
            fiboString.append(old+cur);
            //return fiboString.toString();
        } else
        {
            fiboString.append(fibonacciRec(cur, old+cur,iter-1));
        }
        return fiboString.toString();
    }

    private StringBuffer fiboRec(int iter) {
        StringBuffer fiboString = new StringBuffer("");
        if (iter <= 1) {
            fiboString.append(1);
            return fiboString;
        }
        else {
            fiboString.append(int(fiboRec(iter - 1)) + int (fiboRec(iter - 2)));
            return fiboString;
        }
    } */

}
