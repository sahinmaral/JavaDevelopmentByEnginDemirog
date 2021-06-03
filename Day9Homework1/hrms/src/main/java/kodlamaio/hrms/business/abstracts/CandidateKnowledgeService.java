package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CandidateKnowledge;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobHistory;

import java.util.List;

public interface CandidateKnowledgeService {
    Result add(CandidateKnowledge candidateKnowledge);
    Result addOneByOne(List<CandidateKnowledge> candidateKnowledges, Cv cv);
}
