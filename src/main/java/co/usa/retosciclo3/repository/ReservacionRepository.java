package co.usa.retosciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retosciclo3.repository.crud.ReservacionCrudRepository;
import co.usa.retosciclo3.model.Reservacion;

@Repository
public class ReservacionRepository {

    @Autowired
    private ReservacionCrudRepository reservacionCrudRepository;

    public List<Reservacion> getAll() {
        return (List<Reservacion>) reservacionCrudRepository.findAll();
    }

    public Optional<Reservacion> getReservacion(int id) {
        return reservacionCrudRepository.findById(id);
    }

    public Reservacion save(Reservacion rs) {
        return reservacionCrudRepository.save(rs);
    }

    public Reservacion update(Reservacion rs) {
        return reservacionCrudRepository.save(rs);
    }

    public void delete(Reservacion rs) {
        reservacionCrudRepository.delete(rs);
    }

}
