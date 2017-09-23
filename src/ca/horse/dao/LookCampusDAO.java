package ca.horse.dao;

import java.util.List;

import ca.horse.core.data.LocationSearchCriteria;
import ca.horse.core.data.LookCampus;

public interface LookCampusDAO {
	LookCampus getLookCampusById(int id);
	List<LookCampus> search(LocationSearchCriteria c);
	LookCampus save(LookCampus lookCampus);
}
