package umc.spring.domain.embedded;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 20)
    private String street;
    @Column(nullable = false, length = 20)
    private String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
