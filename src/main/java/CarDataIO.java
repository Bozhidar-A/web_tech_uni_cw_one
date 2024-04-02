
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_tech_uni_cw_one.Database;
import web_tech_uni_cw_one.Vehicle;

/**
 * Servlet implementation class CarDataIO
 */
@WebServlet("/CarDataIO")
public class CarDataIO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private enum params {
			make,
			model,
			maxPassengers,
			manufactureYear,
			gasUsage,
			color,
			gearboxType
	}
	
    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

	/**
	 * Default constructor.
	 */
	public CarDataIO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        Database inst = Database.getInstance();
	        ArrayList<Vehicle> vehicleList = inst.getAllVehicles();

	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Vehicle Data Form</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2>Enter Vehicle Data</h2>");
	        out.println("<form action=\"CarDataIO\" method=\"post\">");

	        for (params param : params.values()) {
	            out.println("<label for=\"" + param.name() + "\">" + capitalize(param.name()) + ":</label><br>");
	            if (param == params.maxPassengers || param == params.manufactureYear || param == params.gasUsage) {
	                out.println("<input type=\"number\" id=\"" + param.name() + "\" name=\"" + param.name() + "\" required><br>");
	            } else if (param == params.gearboxType) {
	                out.println("<select id=\"" + param.name() + "\" name=\"" + param.name() + "\" required>");
	                for (Vehicle.gearboxTypeAvailable type : Vehicle.gearboxTypeAvailable.values()) {
	                    out.println("<option value=\"" + type.name().toLowerCase() + "\">" + type.name() + "</option>");
	                }
	                out.println("</select><br><br>");
	            } else {
	                out.println("<input type=\"text\" id=\"" + param.name() + "\" name=\"" + param.name() + "\" required><br>");
	            }
	        }

	        out.println("<input type=\"submit\" value=\"Submit\">");
	        out.println("</form>");
	        
//	        display data
	        if (!vehicleList.isEmpty()) {
	            // Start table
	            out.println("<table border=\"1\">");
	            out.println("<tr>");
	            out.println("<th>ID</th>");
	            out.println("<th>Make</th>");
	            out.println("<th>Model</th>");
	            out.println("<th>Max Passengers</th>");
	            out.println("<th>Manufacture Year</th>");
	            out.println("<th>Gas Usage</th>");
	            out.println("<th>Color</th>");
	            out.println("<th>Gearbox Type</th>");
	            out.println("</tr>");

	            // Iterate over each vehicle and add a row to the table
	            for (Vehicle vehicle : vehicleList) {
	                out.println("<tr>");
	                out.println("<td>" + vehicle.getID() + "</td>");
	                out.println("<td>" + vehicle.getMake() + "</td>");
	                out.println("<td>" + vehicle.getModel() + "</td>");
	                out.println("<td>" + vehicle.getMaxPassangers() + "</td>");
	                out.println("<td>" + vehicle.getManufactureYear() + "</td>");
	                out.println("<td>" + vehicle.getGasUsage() + "</td>");
	                out.println("<td>" + vehicle.getColor() + "</td>");
	                out.println("<td>" + vehicle.getGearboxType() + "</td>");
	                out.println("</tr>");
	            }

	            // End table
	            out.println("</table>");
	        } else {
	            out.println("<p>No vehicles found</p>");
	        }

	        
	        out.println("</body>");
	        out.println("</html>");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vehicle tmp = new Vehicle(
				request.getParameter(params.make.toString()),
				request.getParameter(params.model.toString()),
				Integer.parseInt(request.getParameter(params.maxPassengers.toString())),
				Integer.parseInt(request.getParameter(params.manufactureYear.toString())),
				Integer.parseInt(request.getParameter(params.gasUsage.toString())),
				request.getParameter(params.color.toString()),
				request.getParameter(params.gearboxType.toString())
		);
		
		Database inst = Database.getInstance();
		inst.AddVehicle(tmp);
		
		doGet(request, response);
	}

}
