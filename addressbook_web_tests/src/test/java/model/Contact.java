package model;

public record Contact(String id, String lastname, String firstname, String address, String photo) {

    public Contact() {
        this( "", "", "", "", "");
    }

    public Contact withId(String id) {
        return new Contact(id, this.lastname, this.firstname, this.address, this.photo);
    }

    public Contact withLastname(String lastname) {
        return new Contact(this.id, lastname, this.firstname, this.address, this.photo);
    }

    public Contact withFirstname(String firstname) {
        return new Contact(this.id, this.lastname, firstname, this.address, this.photo);
    }

    public Contact withAddress(String address) {
        return new Contact(this.id, this.lastname, this.firstname, address, this.photo);
    }

    public Contact withPhoto(String photo) {
        return new Contact(this.id, this.lastname, this.firstname, this.address, photo);
    }
}
