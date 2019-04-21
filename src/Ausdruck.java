public class Ausdruck
{
    public String ausdruck;
    public Ausdruck(String a)
    {
        ausdruck = a;
    }
    public boolean istEingeklammert()
    {
        boolean istKorrektEingeklammert = true;
        int laenge = ausdruck.length();
        int position;
        int counter = 0;
        for (position = 0; position <= (laenge - 1); position++)
        {
            if (ausdruck.charAt(position) == '(')
            {
                counter++;
            }
            if (ausdruck.charAt(position) == ')')
            {
                counter--;
            }
            if (counter < 0)
            {
                return false;
            }
        }
        if (counter != 0)
        {
            return false;
        }
        return true;
    }
}
