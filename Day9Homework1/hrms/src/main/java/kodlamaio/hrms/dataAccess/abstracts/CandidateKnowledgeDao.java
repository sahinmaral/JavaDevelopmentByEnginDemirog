package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateKnowledge;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateKnowledgeDao extends JpaRepository<CandidateKnowledge,Integer> {

}
