package it.ecole.hello.www.app;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class RegisterForm {

    @NotBlank
    private String nom;
    @NotBlank
    @Pattern(regexp = "\\w(\\w|\\.)*@\\w(\\w|\\.)*")
    private String  email;
    @NotBlank
    private String password;

    public RegisterForm(String nom, String email, String password){
        super();

        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public  String getNom() {
        return nom;

    }
    public  void setNom(String nom) {
        this.nom = nom;

    }

    public  String getEmail() {
        return email;

    }
    public  void setEmail(String email) {
        this.email= email;

    }


    public  String getPassword() {
        return password;

    }


    public  void setPassword(String password) {
        this.password= password;

    }

}



