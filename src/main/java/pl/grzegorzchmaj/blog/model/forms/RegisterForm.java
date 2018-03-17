package pl.grzegorzchmaj.blog.model.forms;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    @Size(min = 6, message = "Nazwa uzytkownika musi posiadac minimum {min} znakow. Podana fraza {validatedValue} nie pasuje do wytycznych")
    private String username;

    @Pattern(regexp = "[A-z0-9.]+@[a-z\\-]+\\.[a-z]{2,5}", message = "Podaj prawidlowy email")
    private String email;

    @Size(min=6, max=10, message = "Haslo musi zawierac sie w przedziale {min} - {max} znakow")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
