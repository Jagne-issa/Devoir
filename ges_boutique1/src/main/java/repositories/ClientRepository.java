package repositories;

import entities.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClientParTelephone(String telephone) {
        for (Client client : clients) {
            if (client.getTelephone().equals(telephone)) {
                return client;
            }
        }
        return null;
    }
}
