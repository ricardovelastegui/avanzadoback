package ec.sasf.mscomppruebaAndreVelastegui.services.company;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.mscomppruebaAndreVelastegui.dto.AdDTO;
import ec.sasf.mscomppruebaAndreVelastegui.entity.Ad;
import ec.sasf.mscomppruebaAndreVelastegui.entity.User;
import ec.sasf.mscomppruebaAndreVelastegui.repository.AdRepository;
import ec.sasf.mscomppruebaAndreVelastegui.repository.UserRepository;
import io.jsonwebtoken.io.IOException;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;
    

    public boolean postAd(Long userId, AdDTO adDTO) throws java.io.IOException{
        Optional<User> optionalUser = userRepository.findById(userId);
        if ( optionalUser.isPresent()){
            Ad ad = new Ad();
            ad.setFecha(adDTO.getFecha());
            ad.setStatus(adDTO.getStatus());
            ad.setImg(adDTO.getImg().getBytes());
            ad.setPrice(adDTO.getPrice());
            ad.setUser(optionalUser.get());
            adRepository.save(ad);
            return true;
        }
        return false;
    }

    public List<AdDTO> getAllAds(Long userId){
        return adRepository.findAllByUserId(userId).stream().map(Ad::getAdDto).collect(Collectors.toList());
        
    }
    ´public AdDTO getAdById(Long adId){
        Optional<Ad> optionalAd=
    }

   
}
