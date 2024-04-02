package web_tech_uni_cw_one;

import java.util.ArrayList;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("db")
public class Database {
	private static Database instance;
	private static ArrayList<Vehicle> vehicleList;

	public Database() {
		if (vehicleList == null) {
			vehicleList = new ArrayList<Vehicle>();
		}
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehicle> getAllVehicles() {
		return vehicleList;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getVehicleByID(@PathParam("id") int id) {

		for (Vehicle v : vehicleList) {
			if (v.getID() == id) {
				return v;
			}
		}

		ResponseBuilder rb = Response.status(404);
		return rb.build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vehicle AddVehicle(Vehicle newV) {
		int lastIndex = vehicleList.size() - 1;

		int nextAvailableID = 1;

		if (lastIndex != -1) {
			nextAvailableID = vehicleList.get(lastIndex).getID() + 1;
		}

		newV.setID(nextAvailableID);

		vehicleList.add(newV);

		return newV;
	}
}
