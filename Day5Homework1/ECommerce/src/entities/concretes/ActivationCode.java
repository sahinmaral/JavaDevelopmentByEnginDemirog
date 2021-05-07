package entities.concretes;

import entities.abstracts.Entity;

public class ActivationCode implements Entity {
    private int id;
    private int customerId;
    private String activationCode;

    public ActivationCode(int id, int customerId, String activationCode) {
        super();
        this.setId(id);
        this.setCustomerId(customerId);
        this.setActivationCode(activationCode);
    }
    public ActivationCode()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
