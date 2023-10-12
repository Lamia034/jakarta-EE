package backend.services;

import backend.dto.Client;
import backend.implementations.ClientImplementation;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientImplementation clientI;
    public ClientService(ClientImplementation clientI){
        this.clientI = clientI;
    }

    public Optional<Client> addclient(Client client) {
        return clientI.add(client);
    }
    public List<Client> getAllClients(){return clientI.getAllClients();}
    public Optional<Client> getClientById(Integer clientId) {
        return clientI.getClientById(clientId);
    }
    public Optional<Client> updateClient(Client existingClient) {
        return clientI.update(existingClient);
    }
}
