package co.usa.retosciclo3.repository.crud;

import co.usa.retosciclo3.model.Reservacion;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservacionCrudRepository extends CrudRepository<Reservacion, Integer> {

    @Query("select r.client, COUNT(r.client) from Reservacion as r group by r.client order by COUNT(r.client) desc ")
    public List<Object[]> countTotalReservacionByCliente();

    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservacion> findAllByStatus(String status);
}
