package com.sofserve.lv_427.tourfirm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visa {
  private int id;
  private String visaName;
  private int countryId;
  private int clientId;
}
