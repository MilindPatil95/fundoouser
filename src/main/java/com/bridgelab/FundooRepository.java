package com.bridgelab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundooRepository extends JpaRepository<User,Integer>
{

}