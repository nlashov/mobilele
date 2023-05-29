package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.offer.AddOfferDTO;
import bg.softuni.mobilele.service.BrandService;
import bg.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {

    public OfferService offerService;
    private BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "offers";
    }

    @GetMapping("offers/add")
    public String addOffer(Model model) {
        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult); //Ако това го няма html ще получи празен userModel.
            return "redirect:/offers/add"; // връща userModel-а към GET-а с помощта на POST - redirect - GET
        }
        //TODO
        offerService.addOffer(addOfferModel, userDetails);
        return "redirect:/offers/all";
    }
}
