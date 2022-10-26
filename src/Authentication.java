import java.io.Serializable;

public class Authentication implements Serializable
{
    String username, password;
    int authorityLevel, userID;

    // Getters
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getUserID()
    {
        return userID;
    }

    public int getAuthorityLevel()
    {
        return authorityLevel;
    }

    // Setters
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public void setAuthorityLevel(int authorityLevel)
    {
        this.authorityLevel = authorityLevel;
    }

}
