package edu.vt.globals;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public final class Methods {
    public static void preserveMessages() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void showMessage(String messageType, String messageSummary, String messageDetail) {

        switch (messageType) {
            case "Information":
                FacesMessage infoMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, messageSummary, messageDetail);
                FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                break;
            case "Warning":
                FacesMessage warningMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, messageSummary, messageDetail);
                FacesContext.getCurrentInstance().addMessage(null, warningMessage);
                break;
            case "Error":
                FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageSummary, messageDetail);
                FacesContext.getCurrentInstance().addMessage(null, errorMessage);
                break;
            case "Fatal Error":
                FacesMessage fatalErrorMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, messageSummary, messageDetail);
                FacesContext.getCurrentInstance().addMessage(null, fatalErrorMessage);
                break;
            default:
                System.out.print("Message Type is Out of Range!");
        }
    }

}
