package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.model.City;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.model.Hotel;
import com.sofserve.lv_427.tourfirm.model.Room;
import com.sofserve.lv_427.tourfirm.service.CountryService;
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
    //    System.out.println(roomService.LoadingRoomsPeriode("2019-01-01","2019-03-30",2));

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
//        List<Room> rooms = service.getAvailableRoomsByHotel(startDate, endDate, 7);//should return empty list
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

  }
}
