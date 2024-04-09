package ec.sasf.mscomppruebaAndreVelastegui.dto;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdDTO {

    private Long id;

    private String fecha; 

    private String status;

    private Double price;


    private MultipartFile img;
    private byte[] returnedImg;

    private Long userId;

    private String companyName;

    public void setServiceName(String fecha) {
        this.fecha = fecha;
    }
    
}
