package Mappers;

import Model.RenewableEnergySource;
import Model.SolarPanel;
import Model.WindTurbine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergySourceMapper {

    public static RenewableEnergySource map(ResultSet rs) throws SQLException {

        String id = rs.getString("id");
        String type = rs.getString("type");

        switch (type) {

            case "SOLAR":
                return new SolarPanel(
                        id,
                        rs.getDouble("sunlightIntensity")
                );

            case "WIND":
                return new WindTurbine(
                        id,
                        rs.getDouble("windSpeed")
                );

            default:
                throw new SQLException("Unknown Energy Source Type: " + type);
        }
    }
}
