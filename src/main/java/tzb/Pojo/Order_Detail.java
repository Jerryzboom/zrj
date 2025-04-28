package tzb.Pojo;


import lombok.Data;

import java.io.Serializable;
@Data
public class Order_Detail implements Serializable {

  private Integer odId;
  private Integer miId;
  private Integer fiId;
  private Integer odState;
  private Integer odPayPrice;
  public Order_Detail(Integer odId, Integer miId, Integer fiId, Integer odState, Integer odPayPrice) {
    this.odId = odId;
    this.miId = miId;
    this.fiId = fiId;
    this.odState = odState;
    this.odPayPrice = odPayPrice;
  }
}