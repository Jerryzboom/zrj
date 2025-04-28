package tzb.Pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Operator_Info implements Serializable {

  private Integer oiId;
  private String oiName;
  private String oiPhoneNumber;
  private String oiEmail;
  private String oiPassword;
  private String oiAddress;
  private Integer iiId;
  public Operator_Info(Integer oiId, String oiName, String oiPhoneNumber, String oiEmail, String oiPassword, String oiAddress, Integer iiId) {
    this.oiId = oiId;
    this.oiName = oiName;
    this.oiPhoneNumber = oiPhoneNumber;
    this.oiEmail = oiEmail;
    this.oiPassword = oiPassword;
    this.oiAddress = oiAddress;
    this.iiId = iiId;
  }
}
