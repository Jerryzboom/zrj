package tzb.Pojo;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class Medicine_Info implements Serializable {

  private Integer miId;
  private String miName;
  private String miDose;
  private Integer miStorageState;
  private LocalDate miBornDate;
  private LocalDate  miExpiry;
  private String miPiciNumber;
  private Integer fiId;
  private String miType;
  private Integer miPurchasePrice;
  private Integer miSalePrice;
  public Medicine_Info(Integer miId, String miName, String miDose, Integer miStorageState, LocalDate  miBornDate, LocalDate  miExpiry, String miPiciNumber, Integer fiId, String miType, Integer miPurchasePrice, Integer miSalePrice) {
    this.miId = miId;
    this.miName = miName;
    this.miDose = miDose;
    this.miStorageState = miStorageState;
    this.miBornDate = miBornDate;
    this.miExpiry = miExpiry;
    this.miPiciNumber = miPiciNumber;
    this.fiId = fiId;
    this.miType = miType;
    this.miPurchasePrice = miPurchasePrice;
    this.miSalePrice = miSalePrice;
  }
}
