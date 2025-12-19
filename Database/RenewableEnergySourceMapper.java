package Database.Mappers;
import Model.RenewableEnergySource;
import Model.SolarPanel;
import Model.WindTurbine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RenewableEnergySourceMapper {
    public static RenewableEnergySource map(ResultSet rs) throws  SQLException{
        String id = rs.getString("id");
        String type = rs.getString("sourceType").toUpperCase();
        double power = rs.getDouble("generatedPower");
        Double sunlight = rs.getObject("sunlightIntensity",Double.class);
        Double wind = rs.getObject("windSpeed",Double.class);
      if ("SOLAR".equals(type)){
          if(sunlight == null)
              sunlight= 0.0;
          return new SolarPanel(id,type,power,sunlight);
    }else if ("WIND".equalsIgnoreCase(type)){
          if(wind==null)
              wind=0.0;
      return new WindTurbine(id,type,power,wind);
      }else {
          throw new SQLException("Unknown energy source type: " + type);
      }
    }
}

