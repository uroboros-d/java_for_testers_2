package model;

public record Contact(String lastname, String firstname, String address) {

    public Contact() {
        this( "", "", "");
    }

    public Contact withLastname(String lastname) {
        return new Contact(lastname, this.firstname, this.address);
    }

    public Contact withFirstname(String firstname) {
        return new Contact(this.lastname, firstname, this.address);
    }

    public Contact withAddress(String address) {
        return new Contact(this.lastname, this.firstname, address);
    }
}
