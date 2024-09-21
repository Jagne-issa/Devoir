package services;

import entities.Client;
import repositories.ClientRepository;
import java.util.List;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientService() {
        //TODO Auto-generated constructor stub
    }

    public void creerClient(String surname, String telephone, String adresse) {
        Client client = new Client(surname, telephone, adresse);
        clientRepository.ajouterClient(client);
    }

    public List<Client> listerClients() {
        return clientRepository.getClients();
    }

    public Client rechercherClientParTelephone(String telephone) {
        return clientRepository.getClientParTelephone(telephone);
    }

    public Client rechercherClientParEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'rechercherClientParEmail'");
    }
}
