package tzb.Pojo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class Storage_Record implements Serializable {

  private Integer srId;
  private Integer siId;
  private Integer miId;
  private Integer oiId;
  private LocalDate srPurchaseDate;
  private Integer srPurchaseNumber;

  public Storage_Record(Integer srId, Integer siId, Integer miId, Integer oiId, LocalDate srPurchaseDate, Integer srPurchaseNumber) {
    this.srId = srId;
    this.siId = siId;
    this.miId = miId;
    this.oiId = oiId;
    this.srPurchaseDate = srPurchaseDate;
    this.srPurchaseNumber = srPurchaseNumber;
  }
}
