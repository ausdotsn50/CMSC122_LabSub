import java.time.LocalDate;

public class ExpiryDate {
    private LocalDate expiryDate;

    public ExpiryDate(int year, int month, int day) {
        this.expiryDate = LocalDate.of(year, month, day);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }    
}