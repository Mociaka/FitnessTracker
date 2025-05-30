package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.typeOfExerciseDTOUpload;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.models.TypeOfExercise;
import org.example.fitnesstracker.repository.TypeOfExerciseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeOfExerciseService {
    private final TypeOfExerciseRepo typeOfExerciseRepo;

    public TypeOfExercise findById(long id) {
        return typeOfExerciseRepo.findById(id).orElseThrow(() ->
                new NotFoundDatabaseException("Type of exercise not found by id: " + id)
        );
    }

    public List<TypeOfExercise> findAll() {
        return typeOfExerciseRepo.findAll();
    }

    public void save(typeOfExerciseDTOUpload upload) {
        typeOfExerciseRepo.save(
                new TypeOfExercise(
                        null,
                        upload.getActivity(),
                        upload.getMET()
                )
        );
    }

    public void delete(long id) {
        typeOfExerciseRepo.deleteById(id);
    }
}
