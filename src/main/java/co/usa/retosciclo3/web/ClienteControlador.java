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

import co.usa.retosciclo3.model.Cliente;
import co.usa.retosciclo3.service.ClienteService;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ClienteControlador {

    @Autowired
    private ClienteService ClienteService;

    @GetMapping("/all")
    public List<Cliente> getClientes() {
        return ClienteService.getAll();
    }

    @GetMapping("/id")
    public Optional<Cliente> getAditorio(@PathVariable("id") int id) {
        return ClienteService.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cl) {
        return ClienteService.save(cl);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cl) {
        return ClienteService.update(cl);
    }

    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable("numId") int numId) {
        return ClienteService.deleteCliente(numId);
    }

}
