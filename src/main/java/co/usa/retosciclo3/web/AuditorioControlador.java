package co.usa.retosciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.usa.retosciclo3.model.Auditorio;
import co.usa.retosciclo3.service.AuditorioService;

@RestController
@RequestMapping("api/Audience")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AuditorioControlador {

    @Autowired
    private AuditorioService auditorioService;

    @GetMapping("/all")
    public List<Auditorio> getAuditorios() {
        return auditorioService.getAll();
    }

    @GetMapping("/id")
    public Optional<Auditorio> getAditorio(@PathVariable("id") int id) {
        return auditorioService.getAuditorio(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save(@RequestBody Auditorio aud) {
        return auditorioService.save(aud);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio update(@RequestBody Auditorio aud) {
        return auditorioService.update(aud);
    }

    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAuditorio(@PathVariable("numId") int numId) {
        return auditorioService.deleteAuditorio(numId);
    }

}
