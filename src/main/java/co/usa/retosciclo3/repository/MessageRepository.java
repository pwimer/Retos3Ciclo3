package co.usa.retosciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retosciclo3.repository.crud.MessageCrudRepository;
import co.usa.retosciclo3.model.Message;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message ms) {
        return messageCrudRepository.save(ms);
    }

    public Message update(Message ms) {
        return messageCrudRepository.save(ms);
    }

    public void delete(Message ms) {
        messageCrudRepository.delete(ms);
    }

}
