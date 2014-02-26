package pe.com.yambal.dao;

import pe.com.yambal.base.GenericDao;
import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.pojo.Client;

public interface ClientDao extends GenericDao<ClientDTO> {

	public Integer saveClient(ClientDTO c);
	public Client searchByDni(ClientDTO client) throws Exception;
	 public Client findPaUserByEmailV2(ClientDTO paUser) throws Exception;
}
