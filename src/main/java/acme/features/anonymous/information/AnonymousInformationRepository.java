package acme.features.anonymous.information;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.info.Info;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInformationRepository extends AbstractRepository {

	@Query("select i from Info i")
	Info findOne();
}
