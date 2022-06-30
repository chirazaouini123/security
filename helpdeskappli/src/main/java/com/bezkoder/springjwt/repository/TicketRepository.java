package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel,Long> {
    //@Query("select t from TicketModel t where t.requester=?1")
    List<TicketModel> findByRequester(String requester);


}
