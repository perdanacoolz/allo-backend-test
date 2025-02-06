package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.CalegPage;
import com.allobank.allobackendtest.model.CalegSearchCriteria;
import com.allobank.allobackendtest.repository.CalegCriteriaRepository;
import com.allobank.allobackendtest.repository.CalegRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class CalegService {
    
    @SuppressWarnings("unused")
    private final CalegRepository calegRepository;
    private final CalegCriteriaRepository calegCriteriaRepository;

    public CalegService(CalegRepository calegRepository,
    CalegCriteriaRepository calegCriteriaRepository) {
        this.calegRepository = calegRepository;
        this.calegCriteriaRepository = calegCriteriaRepository;
    }

    public Page<Caleg> getCalegs(CalegPage calegPage,
                                       CalegSearchCriteria calegSearchCriteria){
        return calegCriteriaRepository.findAllWithFilters(calegPage, calegSearchCriteria);
    }

    public Caleg addCaleg(Caleg employee){
        return calegRepository.save(employee);
    }
}
