package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.dao.CountryDao;
import com.sofserve.lv_427.tourfirm.dao.RoomDao;
import com.sofserve.lv_427.tourfirm.model.*;
import com.sofserve.lv_427.tourfirm.service.*;
import com.sofserve.lv_427.tourfirm.service.impl.*;
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
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    //    CityServiceImpl service = new CityServiceImpl();
    //    String startDate = "2019-07-12";
    //    String endDate = "2019-07-20";
    //
    //    List<City> cities = service.getCityWithAvailableHotels(startDate, endDate);
    //
    //    for (City city : cities) {
    //      System.out.println(city.getCityName());
    //    }
    //    public static void main(String[] args) throws SQLException, ClassNotFoundException,
    // ParseException {
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

    //    VisaServiceImpl hotel = new VisaServiceImpl();
    //    System.out.println(hotel.getCountVisaForCountry(1));

    //    RoomServiceImpl roomService = new RoomServiceImpl();
    //    int[] load = new int[2];
    //    load = roomService.LoadingRoomsPeriod("2019-01-01", "2019-03-30", 4);
    //    for (int ar : load) System.out.println(ar);

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
    //        List<Room> rooms = service.getAvailableRoomsByHotel(startDate, endDate, 7);//should
    // return empty list
    //
    //        for(Room room : rooms) {
    //            System.out.println(room.getRoomNumber());
    //        }
    //        HotelServiceImpl service = new HotelServiceImpl();
    //        String startDate = "2019-07-12";
    //        String endDate = "2019-08-20";
    //
    //        List<Hotel> hotels = service.getAvailableHotelsInCity(4, startDate, endDate);
    //
    //        for(Hotel hotel : hotels) {
    //            System.out.println(hotel.getHotelName());
    //        }

    //        RoomServiceImpl service = new RoomServiceImpl();
    //        String startDate = "2019-07-12";
    //        String endDate = "2019-08-20";
    //
    //        List<Room> rooms = service.getAvailableRoomsByHotel(startDate, endDate, 7);//should
    // return empty list
    //
    //        for(Room room : rooms) {
    //            System.out.println(room.getRoomNumber());
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
    //        List<Room> rooms = service.getAvailableRoomsByHotel(startDate, endDate, 7);//should
    // return empty list
    //
    //        for(Room room : rooms) {
    //            System.out.println(room.getRoomNumber());
    //        }

    //    	VisaServiceImpl vs=new VisaServiceImpl();
    //    	System.out.println(vs.getVisasCountForTheClient(1));

    //
    //    VisaService visaService = new VisaServiceImpl();
    //    CountryService countryService = new CountryServiceImpl();
    //
    //    List<Country> countries = countryService.getCountryList();
    //    for (Country country : countries) {
    //
    // System.out.print(visaService.getCountVisaForCountry(countryService.getCountryIdByName(country.getCountryName())) + " ");
    //      System.out.println("видано в " + country.getCountryName());
    //    }
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

//    HotelServiceImpl service = new HotelServiceImpl();
//    System.out.println(service.getAverageBookTime(1, "2016-04-05", "2019-11-05"));

    //    ClientService clientService = new ClientServiceImpl();
    //    Client client = clientService.getClient(Integer.parseInt("2"));
    //    System.out.println(client);

    //    RoomService roomService = new RoomServiceImpl();
    //    int[] result = roomService.LoadingRoomsPeriod("2019-01-01", "2019-03-30", 4);
    //    System.out.println(result[0]);
    //    System.out.println(result[1]);
    //  }

//    CountryDao countryDao = new CountryDao(JdbcConnector.getConnection());
//    System.out.println(countryDao.getVisitedCountriesByClient(1));

//    HotelService hotelService = new HotelServiceImpl();
//
//    hotelService.getClientCountForPeriod(
//            hotelService.getHotelIdByName(session.getAttribute("hotel").toString()),
//            session.getAttribute("start_date_hotel_stat").toString(),
//            session.getAttribute("end_date_hotel_stat").toString()
//    )

    RoomService roomService = new RoomServiceImpl();

    roomService.getRoomCount(1);

//    int[] roomsLoading = roomService.LoadingRoomsPeriod("2019-01-01", "2019-06-20", 2);
//
//    System.out.println(roomsLoading[0]);
//    System.out.println(roomsLoading[1]);
  }
}
