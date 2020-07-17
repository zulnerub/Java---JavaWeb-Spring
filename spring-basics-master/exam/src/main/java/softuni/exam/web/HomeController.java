package softuni.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView){
        if (httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject("foods", this.productService.findAllFoodProducts());
            modelAndView.addObject("drinks", this.productService.findAllDrinkProducts());
            modelAndView.addObject("households", this.productService.findAllHouseholdProducts());
            modelAndView.addObject("others", this.productService.findAllOtherProducts());
            modelAndView.addObject("totalPrice", this.productService.totalPriceAllProducts());
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
