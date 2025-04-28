package tzb.Pojo;


import lombok.Data;

import java.io.Serializable;
@Data
public class Identity_Info implements Serializable {

  private Integer iiId;
  private String iiType;
  public Identity_Info(Integer iiId, String iiType) {
    this.iiId = iiId;
    this.iiType = iiType;
  }
}
