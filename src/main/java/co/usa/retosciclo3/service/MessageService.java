package co.usa.retosciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retosciclo3.model.Message;
import co.usa.retosciclo3.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository MessageRepository;

    public List<Message> getAll() {
        return MessageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return MessageRepository.getMessage(id);
    }

    public Message save(Message ms) {
        if (ms.getIdMessage() == null) {
            return MessageRepository.save(ms);
        } else {
            Optional<Message> paux = MessageRepository.getMessage(ms.getIdMessage());
            if (paux.isEmpty()) {
                return MessageRepository.save(ms);
            } else {
                return ms;
            }
        }
    }

    public Message update(Message ms) {
        if (ms.getIdMessage() != null) {
            Optional<Message> consulta = MessageRepository.getMessage(ms.getIdMessage());
            if (!consulta.isEmpty()) {
                if (ms.getMessageText() != null) {
                    consulta.get().setMessageText(ms.getMessageText());
                }
                return MessageRepository.update(consulta.get());
            }

        }
        return ms;
    }

    public boolean deleteMessage(int numId) {

        Optional<Message> consulta = MessageRepository.getMessage(numId);
        if (!consulta.isEmpty()) {
            MessageRepository.delete(consulta.get());
            return true;

        }
        return false;
    }
}
