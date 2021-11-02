package co.usa.retosciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retosciclo3.repository.crud.AuditorioCrudRepository;
import co.usa.retosciclo3.model.Auditorio;

@Repository

public class AuditorioRepository {

    @Autowired
    private AuditorioCrudRepository auditorioCrudRepository;

    public List<Auditorio> getAll() {
        return (List<Auditorio>) auditorioCrudRepository.findAll();
    }

    public Optional<Auditorio> getAuditorio(int id) {
        return auditorioCrudRepository.findById(id);
    }

    public Auditorio save(Auditorio aud) {
        return auditorioCrudRepository.save(aud);
    }

    public Auditorio update(Auditorio aud) {
        return auditorioCrudRepository.save(aud);
    }

    public void delete(Auditorio aud) {
        auditorioCrudRepository.delete(aud);
    }

}
