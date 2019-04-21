public class Klammerproblem
{
    public static void main(String[] args)
    {
        new Klammerproblem().top();

    }
    void top()
    {
        teste("()", true);
        teste(")(", false);
        teste("(2 + ) ((3) - )", true);
        teste("( () ))((  )", false);
        teste(")", false);
        teste("x", true);
        teste("x(", false);
        teste("((())))", false);
    }
    void teste(String klammerausdruck, boolean soll)
    {
        int fehlerposition = fehlerpos(klammerausdruck);

        if(0 == fehlerposition && soll)
        {
            System.out.println(klammerausdruck + " ist OK");
        } else if(0 < fehlerposition && !soll)
        {
            System.out.println(klammerausdruck + " wurde korrekt als fehlerhaft interpretiert");
        } else
            {
            System.out.println("ERROR: Der Klammeraudruck \"" + klammerausdruck + "\" wurde falsch interpretiert!! Fehler an Pos " + fehlerposition );
        }
    }
    /* Gibt 0 zurück, wenn kein Fehler auftrat. */
    /* Fällt der Klammerausdruck ins Negative, wird die aktuelle Position als Fehlerposition zurückgegeben
    Wenn am Schluss des Ausdrucks die Zahl offener Klammern nicht null, wird die Länge des Strings zurückgegeben. */


    int fehlerpos(String ausdruck)
    {
        int aktpos      = 0; /* vor index */
        int klammerzahl = 0;
        while(aktpos < ausdruck.length())
        {
            char zeichen = ausdruck.charAt(aktpos);

            if ('(' == zeichen)
            {
                klammerzahl = klammerzahl + 1;
            }

            else if (')' == zeichen)
            {
                klammerzahl = klammerzahl - 1;
            }
            if (klammerzahl < 0)
            {
                return aktpos + 1;
            }
            aktpos = aktpos + 1;
        }
        if(0 != klammerzahl) return ausdruck.length();
        return 0;
    }

}

