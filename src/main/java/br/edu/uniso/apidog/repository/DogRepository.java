package br.edu.uniso.apidog.repository;

import br.edu.uniso.apidog.dto.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {
}
