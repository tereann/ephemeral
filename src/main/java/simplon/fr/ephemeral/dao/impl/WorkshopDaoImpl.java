package simplon.fr.ephemeral.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import simplon.fr.ephemeral.dao.WorkshopDao;
import simplon.fr.ephemeral.entity.Workshop;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkshopDaoImpl implements WorkshopDao {
    @Autowired
    private WorkshopRepository workshopRepository;

    @Override
    public void saveWorkshop(String title, String location, int places) {
        Workshop workshop = new Workshop();
        workshop.setTitle(title);
        workshop.setLocation(location);
        workshop.setPlaces(places);
        workshopRepository.save(workshop);
    }

    @Override
    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    //@Override
    public Optional<Workshop> getWorkshopById(Long id)  {
        return workshopRepository.findById(id);
    }
}
