package tzb.Pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Order_Record implements Serializable {

  private Integer orId;
  private Integer miId;
  private Integer ciId;
  private LocalDate orSaleDate;
  private Integer orAllPrice;
  private Integer oiId;
  public Order_Record(Integer orId, Integer miId, Integer ciId, LocalDate orSaleDate, Integer orAllPrice, Integer oiId) {
    this.orId = orId;
    this.miId = miId;
    this.ciId = ciId;
    this.orSaleDate = orSaleDate;
    this.orAllPrice = orAllPrice;
    this.oiId = oiId;
  }
}
