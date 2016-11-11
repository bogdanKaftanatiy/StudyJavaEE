package beans;

import entities.Candidate;
import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.ejb.*;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchBean {
    private final static Logger logger = Logger.getLogger(SearchBean.class);
    @EJB
    private CandidateBean candidateBean;
    @EJB
    private VacancyBean vacancyBean;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void searchCandidate(Vacancy vacancy, int year) {
        List<Candidate> candidateList = candidateBean.getAllObjects();

        for (Candidate c : candidateList) {
            if(c.getYearExperience() < year)
                continue;
            while (true) {
                try {
                    boolean result = offerJob(c);
                    if(result) {
                        logger.warn("Find candidate");
                        break;
                    }
                } catch (RuntimeException e) {
                    logger.error("error!");
                }
            }

        }
        logger.warn("Transaction ends");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean offerJob(Candidate c) {
        if(!c.reviewOffer()) {
            logger.error("Transaction error!\nCandidate don't agree");
            throw new RuntimeException("Candidate don't agree");
        }
        return true;
    }
}
