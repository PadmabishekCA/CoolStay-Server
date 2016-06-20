package com.cool.stay.server.server;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cool.stay.server.dao.impl.CuisineDAOImpl;
import com.cool.stay.server.dao.impl.CuisineOrderDAOImpl;
import com.cool.stay.server.dao.impl.GamesBookingDAOImpl;
import com.cool.stay.server.dao.impl.GamesDAOImpl;
import com.cool.stay.server.dao.impl.ItineraryDAOImpl;
import com.cool.stay.server.dao.impl.SlotDAOImpl;
import com.cool.stay.server.dao.impl.UserDAOImpl;
import com.cool.stay.server.dto.Cuisine;
import com.cool.stay.server.dto.CuisineOrder;
import com.cool.stay.server.dto.CuisineResponse;
import com.cool.stay.server.dto.Games;
import com.cool.stay.server.dto.GamesBooking;
import com.cool.stay.server.dto.Itinerary;
import com.cool.stay.server.dto.Slot;
import com.cool.stay.server.dto.User;
import com.cool.stay.server.processor.ImageProcessor;
import com.cool.stay.server.utils.Utils;

/**
 * Basic web handler
 * 
 * @author parkhan
 *
 */
public class WebController {
	public static void main(String[] args) throws InterruptedException {
		changeSettings();

		post("/justCheck", (req, res) -> {
			System.out.println("Request justCheck");
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			ImageProcessor imp = new ImageProcessor();
			imp.saveImage(map.get("img").toString());
			imp.loadImage("C:\\Users\\parkhan\\Desktop\\test3.jpg", "select ans from img_set", "ans");
			return imp.loadImage("C:\\Users\\parkhan\\Desktop\\test3.jpg", "select ans from img_set", "ans");
		});

		// ********************************************************
		// User specific queries
		// ********************************************************
		post("/createUser", (req, res) -> {
			System.out.println("Request: Create user " + req.body());
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			(new UserDAOImpl()).addUser(new User(null, map.get("username").toString(), map.get("password").toString(),
					map.get("rolename").toString()));
			return "User Created";
		});

		delete("/deleteUser/:username", (req, res) -> {
			System.out.println("Request: Delete user");
			String username = req.params(":username");
			(new UserDAOImpl()).deleteUser(new User(null, username, null, null));
			return "User deleted";
		});

		get("/getUsers", (req, res) -> {
			System.out.println("User Login confirmation");
			List<User> lst = (new UserDAOImpl()).getUsers();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (User user : lst) {
				
				map.put("uname",  user.getName() );
				map.put("pwd", user.getPassword());
				++ctr;
			}
			return Utils.convertMapToJson(map);
		});
		
		get("/confirmUser/:username", (req, res) -> {
			
			String username = req.params(":username");
			String lst = (new UserDAOImpl()).confirmUser(username);
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();	
				map.put("isLogin",  lst );
			return Utils.convertMapToJson(map);
		});
		
		get("/getAllDetails", (req, res) -> {
			System.out.println("Get all details in single shot");
			Map map = (new UserDAOImpl()).getAllDetails();
			return Utils.convertMapToJson(map);
		});

		// ********************************************************
		// Cuisine specific queries
		// ********************************************************
		post("/createCuisine", (req, res) -> {
			/*System.out.println("Request: Create cuisine " + req.body());
			JSONObject jObject = new JSONObject(req.body());
			JSONArray jarray= jObject.getJSONArray("classroom");
			System.out.println("Request: Create jarray " + jarray);
			Iterator it =jarray.iterator();
			while(it.hasNext())
			{
				JSONObject jObjectit = (JSONObject)it.next();
				Iterator<?> keys = jObjectit.keys();

				while (keys.hasNext()) {
					String key = (String) keys.next();
					String value = jObjectit.getString(key);
					//map.put(key, value);
					System.out.println("Key : "+key + " value :"+ value);
				}
				
			}*/
			Map map = (new UserDAOImpl()).getAllDetails();
			return Utils.convertMapToJson(map);
			})	;

		delete("/deleteCuisine/:username", (req, res) -> {
			System.out.println("Request: Delete cuisine");
			String username = req.params(":username");
			System.out.println("name = " + username);
			(new CuisineDAOImpl()).deleteCuisine(new Cuisine(null, username, null, null, null, null));
			return "Cuisine deleted";
		});

		get("/getCuisines", (req, res) -> {
			System.out.println("Inside Controller food");
			List<Cuisine> lst = (new CuisineDAOImpl()).getCuisines();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (Cuisine user : lst) {
				map.put(user.getName(),user.getDescription());
			}
			return Utils.convertMapToJson(map);
		});

	
		
		post("/orderCuisine", (req, res) -> {
			System.out.println("Request for ordering food " + req.body());
			JSONObject jObject = new JSONObject(req.body());
			JSONArray jarray= jObject.getJSONArray("classroom");
			System.out.println("Request: Create jarray " + jarray);
			Map ob = new HashMap();
			Iterator it =jarray.iterator();
			while(it.hasNext())	
			{
				JSONObject jObjectit = (JSONObject)it.next();
				Iterator<?> keys = jObjectit.keys();
				String keyName = null;
				while (keys.hasNext()) {
					String key = (String) keys.next();
					String value = jObjectit.getString(key);
					if(key.equalsIgnoreCase("name"))
						keyName = value;
					else if(key.equalsIgnoreCase("value")) 
						ob.put(keyName, value);
					System.out.println("Key : "+key + " value :"+ value);
				}
				System.out.println("Map obkect  :"+ ob.toString());
				
			}
			CuisineOrderDAOImpl order = new CuisineOrderDAOImpl();
			Map resMap= order.addCuisineOrder(ob);
			System.out.println("Response of order"+ Utils.convertMapToJson(resMap));
			return Utils.convertMapToJson(resMap);
			})	;
		
		// ********************************************************
		// Games specific queries
		// ********************************************************
		post("/createGames", (req, res) -> {
			System.out.println("Request: Create games " + req.body());
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			(new GamesDAOImpl()).addGames(new Games(null, map.get("description").toString(),
					map.get("num_of_players").toString(), map.get("image").toString()));
			return "Cuisine Created";
		});

		delete("/deleteGames/:username", (req, res) -> {
			System.out.println("Request: Delete game");
			String username = req.params(":username");
			System.out.println("name = " + username);
			(new GamesDAOImpl()).deleteGames(new Games(null, username, null, null));
			return "Cuisine deleted";
		});

		get("/getGames", (req, res) -> {
			List<Games> lst = (new GamesDAOImpl()).getGames();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (Games user : lst) {
				map.put(String.valueOf(ctr), user.getId() + " : " + user.getDescription() + " : "
						+ user.getNumOfPlayers() + " : " + user.getImage());
				++ctr;
			}
			return Utils.convertMapToJson(map);
		});

		// ********************************************************
		// Games booking specific queries
		// ********************************************************
		post("/createGamesBooking", (req, res) -> {
			System.out.println("Request: Create games booking " + req.body());
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			(new GamesBookingDAOImpl()).addGamesBooking(new GamesBooking(null, map.get("games_id").toString(),
					map.get("userid").toString(), map.get("slotid").toString(), map.get("update_date").toString(),
					map.get("description").toString(), map.get("username").toString(), map.get("saved").toString()));
			return "Cuisine Created";
		});

		delete("/deleteGamesBooking/:username", (req, res) -> {
			System.out.println("Request: Delete game booking");
			String username = req.params(":username");
			System.out.println("name = " + username);
			(new GamesBookingDAOImpl())
					.deleteGamesBooking(new GamesBooking(null, username, null, null, null, null, null, null));
			return "Cuisine deleted";
		});

		get("/getGamesBookings", (req, res) -> {
			List<GamesBooking> lst = (new GamesBookingDAOImpl()).getGamesBookings();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (GamesBooking user : lst) {
				map.put(String.valueOf(ctr),
						user.getId() + " : " + user.getGamesId() + " : " + user.getUserId() + " : " + user.getSlotId()
								+ " : " + user.getUpdateDate() + " : " + user.getDescription() + " : "
								+ user.getUsername() + " : " + user.getSaved());
				++ctr;
			}
			return Utils.convertMapToJson(map);
		});

		// ********************************************************
		// Itinerary specific queries
		// ********************************************************
		post("/createItinerary", (req, res) -> {
			System.out.println("Request: Create itinerary booking " + req.body());
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			(new ItineraryDAOImpl()).addItinerary(new Itinerary(null, map.get("name").toString(),
					map.get("description").toString(), map.get("image").toString(), map.get("route").toString(),
					map.get("vehicle_types").toString(), map.get("max_no").toString(), map.get("user_id").toString()));
			return "Cuisine Created";
		});

		delete("/deleteItinerary/:username", (req, res) -> {
			System.out.println("Request: Delete itinerary booking");
			String username = req.params(":username");
			System.out.println("name = " + username);
			(new ItineraryDAOImpl()).deleteItinerary(new Itinerary(null, username, null, null, null, null, null, null));
			return "Cuisine deleted";
		});

		get("/getItineraries", (req, res) -> {
			List<Itinerary> lst = (new ItineraryDAOImpl()).getItineraries();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (Itinerary user : lst) {
				map.put(String.valueOf(ctr),
						user.getId() + " : " + user.getName() + " : " + user.getDescription() + " : " + user.getImage()
								+ " : " + user.getRoute() + " : " + user.getVehicleTypes() + " : "
								+ user.getMaxNumbers() + " : " + user.getUserId());
				++ctr;
			}
			return Utils.convertMapToJson(map);
		});

		// ********************************************************
		// Slot specific queries
		// ********************************************************
		post("/createSlot", (req, res) -> {
			System.out.println("Request: Create slot " + req.body());
			Map<String, Object> map = Utils.convertJsonToMap(req.body());
			(new SlotDAOImpl()).addSlot(new Slot(map.get("start_time").toString(), map.get("end_time").toString()));
			return "Cuisine Created";
		});

		delete("/deleteSlot/:username", (req, res) -> {
			System.out.println("Request: Delete itinerary booking");
			String username = req.params(":username");
			System.out.println("name = " + username);
			(new SlotDAOImpl()).deleteSlot(new Slot(username, null));
			return "Cuisine deleted";
		});

		get("/getSlots", (req, res) -> {
			List<Slot> lst = (new SlotDAOImpl()).getSlots();
			int ctr = 1;
			Map<String, Object> map = new HashMap<String, Object>();
			for (Slot user : lst) {
				map.put(String.valueOf(ctr), user.getStartTime() + " : " + user.getEndTime());
				++ctr;
			}
			return Utils.convertMapToJson(map);
		});

	}

	public static void changeSettings() {
		port(8080);
	}
}

//
// get("/justCheck", (req, res) -> {
// System.out.println("Request justCheck");
// (new ConnectionManager()).executeQuery("select 1 + 1");
// return "User Created";
// });
//
// post("/createUser", (req, res) -> {
// System.out.println("Request: Create user");
// RequestProcessor.createUser(req.body());
// return "User Created";
// });
//
// delete("/deleteUser/:username", (req, res) -> {
// String username = req.params(":username");
// RequestProcessor.deleteUser(username);
// return "User deleted";
// });
//
// put("/updateUser", (req, res) -> {
// RequestProcessor.createUser(req.body());
// return "User updated";
// });
//
// get("/getUsernames", (req, res) -> {
// System.out.println("Request: Get users");
// return RequestProcessor.getUsers();
// });