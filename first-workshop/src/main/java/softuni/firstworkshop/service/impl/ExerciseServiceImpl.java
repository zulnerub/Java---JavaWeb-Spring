package softuni.firstworkshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.firstworkshop.model.entity.Exercise;
import softuni.firstworkshop.model.service.ExerciseServiceModel;
import softuni.firstworkshop.repository.ExerciseRepository;
import softuni.firstworkshop.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {

        this.exerciseRepository
                .saveAndFlush(this.modelMapper.map(exerciseServiceModel, Exercise.class));
    }
}
