package louuu.quiz.models;

public class rep {
    private String response;
    private boolean validity;

    public rep() {
    }

    public rep(String response, boolean validity) {
        this.response = response;
        this.validity = validity;
    }

    // Getters and Setters

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }
}
