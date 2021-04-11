package Sebo_dao;

import java.util.List;
import sebo_one.Client;

public interface Inter_client {
	public Client addClient(Client client);
	public boolean emailUnique(String email);
	public boolean passwordCheck(String password);
	public Client identifier(String email,String MotPasse);
	public List<Client> getClients();

}
