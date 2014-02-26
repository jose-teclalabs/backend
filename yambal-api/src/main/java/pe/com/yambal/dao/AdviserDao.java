package pe.com.yambal.dao;

import pe.com.yambal.base.GenericDao;
import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.pojo.Adviser;

public interface AdviserDao extends GenericDao<AdviserDTO> {
	
	public AdviserDTO getUserYambal(AdviserDTO adviser);
	public Adviser verifyCodeOfAdviser(AdviserDTO adviser);

}
