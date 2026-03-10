package model;

public record Contact(String id, String lastname, String firstname, String address) {

    public Contact() {
        this( "", "", "", "");
    }

    public Contact withId(String id) {
        return new Contact(id, this.lastname, this.firstname, this.address);
    }

    public Contact withLastname(String lastname) {
        return new Contact(this.id, lastname, this.firstname, this.address);
    }

    public Contact withFirstname(String firstname) {
        return new Contact(this.id, this.lastname, firstname, this.address);
    }

    public Contact withAddress(String address) {
        return new Contact(this.id, this.lastname, this.firstname, address);
    }
}
