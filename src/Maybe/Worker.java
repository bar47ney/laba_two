package Maybe;

/**
 * Created by Сергей on 30.03.2019.
 */



public class Worker extends Human
{
    public String work()
    {
        return "Рабочий";
    }
    public String work_yes()
    {
        return "Работаю!";
    }
    public String work_no()
    {
        return "Не работаю!";
    }
    public boolean wo = false;
}
