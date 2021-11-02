package co.usa.retosciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retosciclo3.model.Categoria;
import co.usa.retosciclo3.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    public List<Categoria> getAll() {
        return CategoriaRepository.getAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return CategoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria ct) {
        if (ct.getId() == null) {
            return CategoriaRepository.save(ct);
        } else {
            Optional<Categoria> paux = CategoriaRepository.getCategoria(ct.getId());
            if (paux.isEmpty()) {
                return CategoriaRepository.save(ct);
            } else {
                return ct;
            }
        }
    }

    public Categoria update(Categoria ct) {
        if (ct.getId() != null) {
            Optional<Categoria> consulta = CategoriaRepository.getCategoria(ct.getId());
            if (!consulta.isEmpty()) {
                if (ct.getName() != null) {
                    consulta.get().setName(ct.getName());
                }
                if (ct.getDescription() != null) {
                    consulta.get().setDescription(ct.getDescription());
                }
                return CategoriaRepository.update(consulta.get());
            }

        }
        return ct;
    }

    public boolean deleteCategoria(int numId) {

        Optional<Categoria> consulta = CategoriaRepository.getCategoria(numId);
        if (!consulta.isEmpty()) {
            CategoriaRepository.delete(consulta.get());
            return true;

        }
        return false;
    }

}
