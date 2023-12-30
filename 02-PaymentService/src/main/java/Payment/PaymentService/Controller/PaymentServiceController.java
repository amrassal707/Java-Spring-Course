package Payment.PaymentService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentServiceController {

    @GetMapping("/paynow/{price}")
    public String paynow(@PathVariable int price) {
        return "payment amount " + price;
    }



}
