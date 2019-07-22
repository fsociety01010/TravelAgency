package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.dao.VisaDao;
import com.sofserve.lv_427.tourfirm.model.City;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.model.Hotel;
import com.sofserve.lv_427.tourfirm.model.Room;
import com.sofserve.lv_427.tourfirm.model.Visa;
import com.sofserve.lv_427.tourfirm.service.VisaService;
import com.sofserve.lv_427.tourfirm.service.impl.CityServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.RoomServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.VisaServiceImpl;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
    	System.out.println("start");
//        CityServiceImpl service = new CityServiceImpl();
//        String startDate = "2019-07-12";
//        String endDate = "2019-07-20";
//
//        List<City> cities = service.getCityWithAvailableHotels(startDate, endDate);
//
//        for(City city : cities) {
//            System.out.println(city.getCityName());
//        }

//        HotelServiceImpl service = new HotelServiceImpl();
//        String startDate = "2019-07-12";
//        String endDate = "2019-07-20";
//
//        List<Hotel> hotels = service.getAvailableHotelsInCity(1, startDate, endDate);
//
//        for(Hotel hotel : hotels) {
//            System.out.println(hotel.getHotelName());
//        }
//
//        RoomServiceImpl service = new RoomServiceImpl();
//        String startDate = "2019-07-04";
//        String endDate = "2019-07-05";
//
//        List<Room> rooms = service.getAvailableRoomsByHotel(startDate, endDate, 7);//should return empty list
//
//        for(Room room : rooms) {
//            System.out.println(room.getRoomNumber());
//        }
    	
//    	VisaServiceImpl vs=new VisaServiceImpl();
//    	System.out.println(vs.getVisasCountForTheClient(1));

//    	VisaDao dao=new VisaDao(JdbcConnector.getConnection());
//    	System.out.println(dao.getVisasForTheClient(1));
    	
//      CountryServiceImpl service = new CountryServiceImpl();
//      List<Country> countries= service.getVisitedCountriesByClient(2);
//      for(Country country : countries) {
//          System.out.println(country); //not finished
//      }
    	
//      VisaServiceImpl service = new VisaServiceImpl();
//      List<Visa> visas = service.getVisasForTheClient(2);
//      for(Visa visa : visas) {
//          System.out.println(visa);
//      }
    	
//      HotelServiceImpl service = new HotelServiceImpl();
//     System.out.println(service.getClientCountForPeriod(1, "2019-05-05", "2019-11-05"));
    	
      HotelServiceImpl service = new HotelServiceImpl();
     System.out.println(service.getAverageBookTime(1, "2016-04-05", "2019-11-05"));
    	

    }
}
