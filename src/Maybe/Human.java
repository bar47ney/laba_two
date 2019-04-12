package Maybe;

/**
 * Created by Сергей on 30.03.2019.
 */


public class Human
{
    private String firstName;
    private String lastName;
    private String status;
    private String activity;
    private boolean boolSt = false;
    Address address;
    public void moveIn()
    {
        address = new Address();
    }
    public void moveOut()
    {
        address = null;
        System.gc();
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public boolean isBoolStatus()
    {
        return boolSt;
    }
    public String getActivity()
    {
        return activity ;
    }
    public void setActivity(String activity)
    {
        this.activity=activity;
    }
    public boolean setBoolStatus(boolean boolSt)
    {
        return this.boolSt = boolSt;
    }
    public Address getAddress()
    {
        return address ;
    }
}
