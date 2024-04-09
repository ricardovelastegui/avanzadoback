package ec.sasf.mscomppruebaAndreVelastegui.services.company;

import java.util.List;

import ec.sasf.mscomppruebaAndreVelastegui.dto.AdDTO;

public interface CompanyService {

    boolean postAd(Long userId, AdDTO adDTO) throws java.io.IOException;
    List<AdDTO> getAllAds(Long userId);
    
}
