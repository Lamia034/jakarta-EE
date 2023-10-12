package backend.interfaces;

import backend.dto.Client;

import java.util.List;
import java.util.Optional;

public interface ClientInterface {
    Optional<Client> add(Client client);
    List<Client> getAllClients();
    Optional<Client> getClientById(Integer clientId);
    Optional<Client> update(Client existingClient);
}
