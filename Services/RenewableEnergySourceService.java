package Services;

import Database.DAO.RenewableEnergySourceDAO;
import Model.RenewableEnergySource;


import java.util.List;

public class RenewableEnergySourceService {
    private final RenewableEnergySourceDAO renewableEnergySourceDAO;
    public RenewableEnergySourceService(){
        this.renewableEnergySourceDAO = new RenewableEnergySourceDAO();
    }
    public List<RenewableEnergySource>getAllSources(){
        return renewableEnergySourceDAO.getAll();
    }
    public RenewableEnergySource getSourceById(String id){
        if(id == null || id.isEmpty())
            return null;
        return renewableEnergySourceDAO.getById(id);
    }
    public boolean addSource(RenewableEnergySource source){
        if (source == null)
            return false;
        if (renewableEnergySourceDAO.getById(source.getId())!= null){
            return false;
        }
        return renewableEnergySourceDAO.add(source);
    }
    public boolean updateGeneratedPower(String id, double newPower){
        if(id == null || newPower < 0)
            return false;
        RenewableEnergySource src = renewableEnergySourceDAO.getById(id);
        if(src == null)
            return false;
        return renewableEnergySourceDAO.updatePower(id,newPower);
    }
    public boolean deleteSource(String id){
        if (id == null)
            return false;
        return renewableEnergySourceDAO.delete(id);
    }
    public boolean clearAllSources(){
        return renewableEnergySourceDAO.RenewableEnergySourcesTable();
    }
}
