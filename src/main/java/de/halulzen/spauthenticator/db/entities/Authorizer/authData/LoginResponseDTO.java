package de.halulzen.spauthenticator.db.entities.Authorizer.authData;

public class LoginResponseDTO {
    private String userId;
    private boolean passwordCorrect;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isPasswordCorrect() {
        return passwordCorrect;
    }

    public void setPasswordCorrect(boolean passwordCorrect) {
        this.passwordCorrect = passwordCorrect;
    }

    public LoginResponseDTO(String userId, boolean passwordCorrect) {
        this.userId = userId;
        this.passwordCorrect = passwordCorrect;
    }
}
