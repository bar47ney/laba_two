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
    public void copy(Student styd)
    {
        this.setFirstName(styd.getFirstName());
        this.setLastName(styd.getLastName());
        this.setStatus(styd.getStatus());
        this.setActivity(styd.getActivity());
    }
    public void changeStatus()
    {
        if(this.isBoolStatus() == true)
        {
            this.setStatus("Учусь");
        }
        else
        {
            this.setStatus("Не учусь");
        }
    }
}
