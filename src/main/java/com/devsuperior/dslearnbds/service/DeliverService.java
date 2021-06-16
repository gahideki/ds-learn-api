package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.model.Deliver;
import com.devsuperior.dslearnbds.repository.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository deliverRepository;

    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO) {
        Deliver deliver = deliverRepository.getOne(id);
        deliver.setStatus(deliverRevisionDTO.getStatus());
        deliver.setFeedback(deliverRevisionDTO.getFeedback());
        deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
        deliverRepository.save(deliver);
    }

}
