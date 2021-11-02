package co.usa.retosciclo3.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.usa.retosciclo3.model.Reservacion;
import co.usa.retosciclo3.repository.ReservacionRepository;

@Service
public class ReservacionService {

    @Autowired
    private ReservacionRepository ReservacionRepository;

    public List<Reservacion> getAll() {
        return ReservacionRepository.getAll();
    }

    public Optional<Reservacion> getReservacion(int id) {
        return ReservacionRepository.getReservacion(id);
    }

    public Reservacion save(Reservacion rs) {
        if (rs.getIdReservation() == null) {
            return ReservacionRepository.save(rs);
        } else {
            Optional<Reservacion> paux = ReservacionRepository.getReservacion(rs.getIdReservation());
            if (paux.isEmpty()) {
                return ReservacionRepository.save(rs);
            } else {
                return rs;
            }
        }
    }

    public Reservacion update(Reservacion rs) {
        if (rs.getIdReservation() != null) {
            Optional<Reservacion> consulta = ReservacionRepository.getReservacion(rs.getIdReservation());
            if (!consulta.isEmpty()) {
                if (rs.getStartDate() != null) {
                    consulta.get().setStartDate(rs.getStartDate());
                }
                if (rs.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(rs.getDevolutionDate());
                }
                return ReservacionRepository.update(consulta.get());
            }

        }
        return rs;
    }

    public boolean deleteReservacion(int numId) {

        Optional<Reservacion> consulta = ReservacionRepository.getReservacion(numId);
        if (!consulta.isEmpty()) {
            ReservacionRepository.delete(consulta.get());
            return true;

        }
        return false;
    }

}
