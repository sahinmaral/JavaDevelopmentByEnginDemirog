package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateKnowledgeService;
import kodlamaio.hrms.business.abstracts.CandidateKnowledgeService;
import kodlamaio.hrms.business.abstracts.ProgrammingTechnologyService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateKnowledgeDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CandidateKnowledge;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateKnowledgeManager implements CandidateKnowledgeService {

    @Autowired
    public CandidateKnowledgeManager
            (
                    CandidateKnowledgeDao candidateKnowledgeDao,
                    ProgrammingTechnologyService programmingTechnologyService
            ) {
        this.candidateKnowledgeDao = candidateKnowledgeDao;
        this.programmingTechnologyService = programmingTechnologyService;
    }

    private final ProgrammingTechnologyService programmingTechnologyService;
    private final CandidateKnowledgeDao candidateKnowledgeDao;
    
    @Override
    public Result add(CandidateKnowledge candidateKnowledge) {
        candidateKnowledgeDao.save(candidateKnowledge);
        return new SuccessResult();
    }

    @Override
    public Result addOneByOne(List<CandidateKnowledge> candidateKnowledges, Cv cv) {
        for (var item : candidateKnowledges){
            item.setCv(cv);

            var programmingTech =
                    programmingTechnologyService.getById
                            (item.getProgrammingTechnology().getId());

            item.setProgrammingTechnology(programmingTech.getData());

            add(item);
        }

        return new SuccessResult();
    }
}
