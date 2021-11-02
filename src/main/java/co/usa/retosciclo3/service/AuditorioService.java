package co.usa.retosciclo3.service;

import co.usa.retosciclo3.repository.AuditorioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import co.usa.retosciclo3.model.Auditorio;
import org.springframework.stereotype.Service;

@Service
public class AuditorioService {

    @Autowired
    private AuditorioRepository auditorioRepository;

    public List<Auditorio> getAll() {
        return auditorioRepository.getAll();

    }

    public Optional<Auditorio> getAuditorio(int id) {
        return auditorioRepository.getAuditorio(id);
    }

    public Auditorio save(Auditorio aud) {
        if (aud.getId() == null) {
            return auditorioRepository.save(aud);
        } else {
            Optional<Auditorio> paux = auditorioRepository.getAuditorio(aud.getId());
            if (paux.isEmpty()) {
                return auditorioRepository.save(aud);
            } else {
                return aud;
            }
        }
    }

    public Auditorio update(Auditorio aud) {
        if (aud.getId() != null) {
            Optional<Auditorio> consulta = auditorioRepository.getAuditorio(aud.getId());
            if (!consulta.isEmpty()) {
                if (aud.getName() != null) {
                    consulta.get().setName(aud.getName());
                }
                if (aud.getOwner() != null) {
                    consulta.get().setOwner(aud.getOwner());
                }
                if (aud.getCapacity() != null) {
                    consulta.get().setCapacity(aud.getCapacity());
                }
                if (aud.getDescription() != null) {
                    consulta.get().setDescription(aud.getDescription());
                }
                return auditorioRepository.update(consulta.get());
            }

        }
        return aud;
    }

    public boolean deleteAuditorio(int numId) {

        Optional<Auditorio> consulta = auditorioRepository.getAuditorio(numId);
        if (!consulta.isEmpty()) {
            auditorioRepository.delete(consulta.get());
            return true;

        }
        return false;
    }

}
