package br.edu.uniso.apidog.service;

import br.edu.uniso.apidog.dto.Dog;
import br.edu.uniso.apidog.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    DogRepository dr;

    public void save(Dog dog){
        dr.save(dog);
    }

    public void delete(int id){
        dr.deleteById(id);
    }

    public List<Dog> listAll(){
        return dr.findAll();
    }

    public Dog get(int id){
        return dr.findById(id).get();
    }
}
