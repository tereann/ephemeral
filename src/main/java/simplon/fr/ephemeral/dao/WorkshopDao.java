package simplon.fr.ephemeral.dao;
import simplon.fr.ephemeral.entity.Workshop;

import java.util.List;
import java.util.Optional;

public interface WorkshopDao {
    void saveWorkshop(String nom, String location, int places);

    List<Workshop> getAllWorkshops();

    //static Optional<Workshop> getWorkshopById(Long id);
}
