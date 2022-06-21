package peaksoft.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Company;

public interface CompanyRepository  extends JpaRepository<Company,Long> {

   }
