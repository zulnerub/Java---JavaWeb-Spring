package softuni.firstworkshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.firstworkshop.model.binding.ExerciseAddBindingModel;
import softuni.firstworkshop.model.service.ExerciseServiceModel;
import softuni.firstworkshop.service.ExerciseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(
            @Valid @ModelAttribute("exerciseAddBindingModel")
                    ExerciseAddBindingModel exerciseAddBindingModel,
            BindingResult bindingResult, RedirectAttributes redirectAttributes){

        System.out.println();
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("exerciseAddBindingModel", exerciseAddBindingModel);
            return "redirect:/exercises/add";
        }else {
            this.exerciseService.addExercise(this.modelMapper
                    .map(exerciseAddBindingModel, ExerciseServiceModel.class));
            return "redirect:/";
        }
    }
}
