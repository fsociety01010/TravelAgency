package com.sofserve.lv_427.tourfirm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomBook {
  private int id;
  private String orderStart;
  private String orderEnd;
  private int roomId;
  private int clientId;
}
