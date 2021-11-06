package co.usa.retosciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import co.usa.retosciclo3.model.Reservacion;
import co.usa.retosciclo3.model.reportes.ContClientes;
import co.usa.retosciclo3.model.reportes.ContEstClientes;
import co.usa.retosciclo3.service.ReservacionService;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ReservacionControlador {

    @Autowired
    private ReservacionService ReservacionService;

    @GetMapping("/all")
    public List<Reservacion> getReservacions() {
        return ReservacionService.getAll();
    }

    @GetMapping("/id")
    public Optional<Reservacion> getAditorio(@PathVariable("id") int id) {
        return ReservacionService.getReservacion(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion rs) {
        return ReservacionService.save(rs);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion rs) {
        return ReservacionService.update(rs);
    }

    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservacion(@PathVariable("numId") int numId) {
        return ReservacionService.deleteReservacion(numId);
    }

    @GetMapping("/report-status")
    public ContEstClientes getReporteEstados() {
        return ReservacionService.getReporteEstados();
    }

    @GetMapping("/report-clients")
    public List<ContClientes> getTopClientes() {
        return ReservacionService.getTopClientes();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")

    public List<Reservacion> getClienteFechas(@PathVariable("dateOne") String fecha1,
            @PathVariable("dateTwo") String fecha2) {
        return ReservacionService.getReservacionFechas(fecha1, fecha2);

    }

}
