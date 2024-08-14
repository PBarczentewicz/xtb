package ProjectData;

import com.example.piotrkrupa.base.BasePage;
import com.example.piotrkrupa.page.HomePage;
import lombok.Builder;
import org.openqa.selenium.WebDriver;


public class BookingForm extends BasePage {
    @Builder
    protected BookingForm(WebDriver driver) {
        super(driver);
    }

    public BookingForm setFirstName(String firstName) {
        findById("firstName").sendKeys(firstName);
        return this;
    }

    public BookingForm setLastName(String lastName) {
        findById("lastName").sendKeys(lastName);
        return this;
    }

    public BookingForm setEmail(String email) {
        findById("email").sendKeys(email);
        return this;
    }

    public BookingForm phone(String phone) {
        findById("phone").sendKeys(phone);
        return this;
    }

    public BookingForm checkIn(String checkIn) {
        findById("checkIn").sendKeys(checkIn);
        return this;
    }

    public BookingForm checkOut(String checkOut) {
        findById("checkOut").sendKeys(checkOut);
        return this;
    }


}
