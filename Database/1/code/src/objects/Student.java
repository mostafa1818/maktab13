package objects;
/*Student class*/
public class Student {

  private  int id;
    private String FirstName;
    private String LastName;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
