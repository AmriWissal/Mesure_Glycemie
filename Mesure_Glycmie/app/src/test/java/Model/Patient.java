package Model;

public class Patient {private int age;
    private float Vmesurer;
    private boolean jen;
    private String result;
    //notify controle---->Model
    public Patient(int age, float Vmesurer, boolean jen)
    {
        this.age=age;
        this.Vmesurer=Vmesurer;
        this.jen=jen;
        calculer();
    }
    public double getAge() {
        return age;
    }

    public double getVmesurer() {
        return Vmesurer;
    }

    public boolean isJen() {
        return jen;
    }
    public String getResult()
    {
        return result;
    }
    private void calculer()
    {
        if (jen=true)
        {
            if (age>=13)
            {
                if (Vmesurer<5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5 && Vmesurer<=7.2)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
            else if (age>=6 && age<=12)
            {
                if (Vmesurer<5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5 && Vmesurer<=10)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
            else if (age<6)
            {
                if (Vmesurer<5.5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5.5 && Vmesurer<=10)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
        }
        else
        {
            if (Vmesurer> 10.5)
                result="niveau de glycémie est élevé";
            else
                result="niveau de glycémie est normale";
        }
    }

}
