package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.dao.RoomDao;
import com.sofserve.lv_427.tourfirm.model.*;
import com.sofserve.lv_427.tourfirm.service.ClientService;
import com.sofserve.lv_427.tourfirm.service.CountryService;
import com.sofserve.lv_427.tourfirm.service.RoomService;
import com.sofserve.lv_427.tourfirm.service.VisaService;
import com.sofserve.lv_427.tourfirm.service.impl.*;

import java.sql.SQLException;
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

//
//    VisaService visaService = new VisaServiceImpl();
//    CountryService countryService = new CountryServiceImpl();
//
//    List<Country> countries = countryService.getCountryList();
//    for (Country country : countries) {
//      System.out.print(visaService.getCountVisaForCountry(countryService.getCountryIdByName(country.getCountryName())) + " ");
//      System.out.println("видано в " + country.getCountryName());
//    }

//    ClientService clientService = new ClientServiceImpl();
//    Client client = clientService.getClient(Integer.parseInt("2"));
//    System.out.println(client);

    RoomService roomService = new RoomServiceImpl();
    int[] result = roomService.LoadingRoomsPeriod("2019-01-01", "2019-03-30", 4);
    System.out.println(result[0]);
    System.out.println(result[1]);
  }
}
