package tzb.Pojo;


import lombok.Data;

import java.io.Serializable;
@Data
public class Factory_Info implements Serializable {

  private Integer fiId;
  private String fiName;
  private String fiPhoneNumber;
  private String fiAddress;

  public Factory_Info(Integer fiId, String fiName, String fiPhoneNumber, String fiAddress) {
    this.fiId = fiId;
    this.fiName = fiName;
    this.fiPhoneNumber = fiPhoneNumber;
    this.fiAddress = fiAddress;
  }
}
