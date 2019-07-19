package com.sofserve.lv_427.tourfirm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private int id;
    private int roomNumber;
    private int hotelId;
}
