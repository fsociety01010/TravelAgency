package com.sofserve.lv_427.tourfirm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
  private int id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
}
