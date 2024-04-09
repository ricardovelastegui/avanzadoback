package ec.sasf.mscomppruebaAndreVelastegui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.sasf.mscomppruebaAndreVelastegui.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{

    List<Ad> findAllByUserId(Long userId);
    
    
}
