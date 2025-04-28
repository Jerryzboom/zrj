package tzb.Pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client_Info implements Serializable {
    private Integer ciId;
    private String ciName;
    private Integer ciAge;
    private String ciPhoneNumber;
    private String ciEmail;
    private String ciAddress;

    public Client_Info(Integer ciId, String ciName, Integer ciAge, String ciPhoneNumber, String ciEmail, String ciAddress) {
        this.ciId = ciId;
        this.ciName = ciName;
        this.ciAge = ciAge;
        this.ciPhoneNumber = ciPhoneNumber;
        this.ciEmail = ciEmail;
        this.ciAddress = ciAddress;
    }
}
