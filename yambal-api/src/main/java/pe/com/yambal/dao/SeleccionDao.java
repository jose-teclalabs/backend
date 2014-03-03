package pe.com.yambal.dao;

import java.util.List;

import pe.com.yambal.base.GenericDao;
import pe.com.yambal.model.SeleccionDTO;

public interface SeleccionDao extends GenericDao<SeleccionDTO>  {
	public Boolean agregarRespuesta(List<SeleccionDTO> respList);

}
