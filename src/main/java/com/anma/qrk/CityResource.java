package com.anma.qrk;

import io.agroal.api.AgroalDataSource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/cities")
public class CityResource {

    @Inject
    AgroalDataSource dataSource;

    @RolesAllowed({"user", "admin"})
    @Path("/{name}")
    @GET
    public City getCityByName(@PathParam("name") String name) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("select * from cities where name like ?");
        statement.setString(1, name);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        City city = new City();
        city.setId(UUID.fromString(resultSet.getString("id")));
        city.setName(resultSet.getString("name"));
        city.setPopulation(resultSet.getInt("population"));
        return city;
    }

    @RolesAllowed("admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> allCities() {

        try {

            CallableStatement statement = dataSource.getConnection().prepareCall("select * from cities");
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            List<City> cities = new ArrayList<>();

            resultSet.next();
            City city = new City();
            city.setId(UUID.fromString(resultSet.getString("id")));
            city.setName(resultSet.getString("name"));
            city.setPopulation(resultSet.getInt("population"));
            cities.add(city);
            while (resultSet.next()) {
                City city2 = new City();
                city2.setId(UUID.fromString(resultSet.getString("id")));
                city2.setName(resultSet.getString("name"));
                city2.setPopulation(resultSet.getInt("population"));
                cities.add(city2);
            }
            return cities;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new ArrayList<>();
    }
}