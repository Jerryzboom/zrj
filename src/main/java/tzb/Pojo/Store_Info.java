package tzb.Pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Store_Info implements Serializable {

  private Integer siId;
  private Integer miId;
  private Integer siMiNumber;
  public Store_Info(Integer siId, Integer miId, Integer siMiNumber) {
    this.siId = siId;
    this.miId = miId;
    this.siMiNumber = siMiNumber;
  }
}
