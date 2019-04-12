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
    public String workYes()
    {
        return "Работаю!";
    }
    public void copy(Worker workk)
    {
        this.setFirstName(workk.getFirstName());
        this.setLastName(workk.getLastName());
        this.setStatus(workk.getStatus());
        this.setActivity(workk.getActivity());
    }
    public String workNo()
    {
        return "Не работаю!";
    }
    public void changeStatus()
    {
        if(this.isBoolStatus() == true)
        {
            this.setStatus("Работаю");
        }
        else
        {
            this.setStatus("Не работаю");
        }
    }
}
