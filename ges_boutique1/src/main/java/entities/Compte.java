package entities;

public class Compte {
    private String email;
    private String password;
    private Role role;
    private boolean actif;

    public Compte(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.actif = true;
    }

    // Getters et setters
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", actif=" + actif +
                '}';
    }
}
