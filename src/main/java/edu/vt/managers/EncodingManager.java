package edu.vt.managers;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;

@Named
@RequestScoped
public class EncodingManager {
    private String encodedUrl;

    // Getters and Setters
    public String getEncodedUrl() {
        return encodedUrl;
    }

    public void setEncodedUrl(String encodedUrl) {
        this.encodedUrl = encodedUrl;
    }

    // Method to encode the current page URL
    public void encodeCurrentUrl() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            String currentUrl = request.getRequestURL().toString();
            encodedUrl = Base64.getEncoder().encodeToString(currentUrl.getBytes());
        }
    }
}
