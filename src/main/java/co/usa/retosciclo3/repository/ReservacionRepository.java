package co.usa.retosciclo3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retosciclo3.repository.crud.ReservacionCrudRepository;
import co.usa.retosciclo3.model.Cliente;
import co.usa.retosciclo3.model.Reservacion;
import co.usa.retosciclo3.model.reportes.ContClientes;

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

    public List<Reservacion> getReservacionPorStatus(String status) {
        return reservacionCrudRepository.findAllByStatus(status);
    }

    public List<Reservacion> getReservacionesFechas(Date dateOne, Date dateTwo) {
        return reservacionCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<ContClientes> getTopClientes() {
        List<Object[]> reporte = reservacionCrudRepository.countTotalReservacionByCliente();
        List<ContClientes> res = new ArrayList<>();

        for (int i = 0; i < reporte.size(); i++) {
            res.add(new ContClientes((Long) reporte.get(i)[1], (Cliente) reporte.get(i)[0]));
        }

        return res;
    }
}
