import java.time.LocalDate;

public class IceCreamTub {
    // Attributes of the IceCreamTub class
    private String flavor;
    private ExpiryDate tubExpiry;

    public IceCreamTub(String flavor, ExpiryDate tubExpiry) {
        this.flavor = flavor;
        this.tubExpiry = tubExpiry;
    }

    public String getFlavor() {
        return flavor;
    }

    public LocalDate getExpiryDate() {
        return tubExpiry.getExpiryDate();
    }
}