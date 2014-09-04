package co.gov.fna.okeda.modelo.entidades;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by usuario on 19/07/14.
 */
public class Usuario {

    private ParseUser user;
    private String email;
    private String mobile;

    public Usuario(ParseUser user) {
        this.user = user;
        this.mobile = user.getString("mobile");
        this.email = user.getEmail();
    }


    public ParseUser getUser() {
        return user;
    }

    public void setUser(ParseUser user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
