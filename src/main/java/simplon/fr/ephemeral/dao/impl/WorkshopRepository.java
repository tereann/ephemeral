package simplon.fr.ephemeral.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import simplon.fr.ephemeral.entity.Workshop;

public interface WorkshopRepository  extends JpaRepository<Workshop, Long> {
}
