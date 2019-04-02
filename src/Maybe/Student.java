package Maybe;

/**
 * Created by Сергей on 30.03.2019.
 */


public class Student extends Human
{
    public String study()
    {
        return "Студент";
    }
    public String study_yes()
    {
        return "Учусь!";
    }
    public String study_no()
    {
        return "Не учусь!";
    }
    public boolean st = false;
}
