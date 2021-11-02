package co.usa.retosciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retosciclo3.model.Cliente;
import co.usa.retosciclo3.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.getAll();
    }

    public Optional<Cliente> getCliente(int id) {
        return clienteRepository.getCliente(id);
    }

    public Cliente save(Cliente cl) {
        if (cl.getIdClient() == null) {
            return clienteRepository.save(cl);
        } else {
            Optional<Cliente> paux = clienteRepository.getCliente(cl.getIdClient());
            if (paux.isEmpty()) {
                return clienteRepository.save(cl);
            } else {
                return cl;
            }
        }
    }

    public Cliente update(Cliente cl) {
        if (cl.getIdClient() != null) {
            Optional<Cliente> consulta = clienteRepository.getCliente(cl.getIdClient());
            if (!consulta.isEmpty()) {
                if (cl.getEmail() != null) {
                    consulta.get().setEmail(cl.getEmail());
                }
                if (cl.getPassword() != null) {
                    consulta.get().setPassword(cl.getPassword());
                }
                if (cl.getName() != null) {
                    consulta.get().setName(cl.getName());
                }
                if (cl.getAge() != null) {
                    consulta.get().setAge(cl.getAge());
                }
                return clienteRepository.update(consulta.get());
            }

        }
        return cl;
    }

    public boolean deleteCliente(int numId) {

        Optional<Cliente> consulta = clienteRepository.getCliente(numId);
        if (!consulta.isEmpty()) {
            clienteRepository.delete(consulta.get());
            return true;

        }
        return false;
    }

}
