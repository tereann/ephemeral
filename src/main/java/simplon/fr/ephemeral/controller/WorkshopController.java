package simplon.fr.ephemeral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import simplon.fr.ephemeral.dao.WorkshopDao;
import simplon.fr.ephemeral.dao.impl.WorkshopRepository;
import simplon.fr.ephemeral.entity.Workshop;

import java.util.List;
import java.util.Optional;

@Controller
public class WorkshopController {
    @Autowired
    private WorkshopDao workshopDao;

    @Autowired
    private WorkshopRepository repo;

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("workshop", new Workshop());
        return "add-form";
    }

    @PostMapping("/addWorkshop")
    public String registerWorkshop(@ModelAttribute("workshop") Workshop workshop) {
        workshopDao.saveWorkshop(workshop.getTitle(), workshop.getLocation(), workshop.getPlaces());
        return "redirect:/manage-workshops";
    }

    @GetMapping ("/")
    public String getAllWorkshops(Model model) {
        List<Workshop> workshops = workshopDao.getAllWorkshops();
        model.addAttribute("workshops", workshops);
        return "index";
    }

    @GetMapping ("/manage-workshops")
    public String getManageWorkshops(Model model) {
        List<Workshop> workshops = workshopDao.getAllWorkshops();
        model.addAttribute("workshops", workshops);
        return "manage-workshops";
    }

    @GetMapping("/workshop/{id}")
    public String getWorkshopById(@PathVariable Long id, Model model) {
        Optional<Workshop> optionalWorkshop = repo.findById(id);
        Workshop workshop = optionalWorkshop.orElseThrow(() -> new IllegalArgumentException("Invalid festival id: " + id));
        model.addAttribute("workshop", workshop);
        return "edit";
    }

    @PostMapping("/workshop/save")
    public String saveEditedWorkshop(@ModelAttribute("workshop") Workshop editedWorkshop) {
        Optional<Workshop> optionalWorkshop = repo.findById(editedWorkshop.getId());
        Workshop workshop = optionalWorkshop.orElseThrow(() -> new IllegalArgumentException("Invalid workshop id:" + editedWorkshop.getId()));


        workshop.setTitle(editedWorkshop.getTitle());
        workshop.setLocation(editedWorkshop.getLocation());
        workshop.setPlaces(editedWorkshop.getPlaces());

        repo.save(workshop);
        return "redirect:/manage-workshops";
    }

    @GetMapping("/workshop/form")
    public String getFormEdit(Model model) {
            model.addAttribute("workshop", new Workshop());
            return "add-form";
        }

    @PostMapping("workshop/{id}/delete")
    public String deleteWorkshop(@PathVariable long id) {repo.deleteById(id);
        return "redirect:/manage-workshops";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }


    @GetMapping("/booking")
    public String makeBooking() {
        return "booking";
    }
}