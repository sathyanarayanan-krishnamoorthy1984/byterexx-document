package com.byterexx.document.correspondence.interfaces.db.persistence;

import com.byterexx.document.correspondence.interfaces.db.domain.CorrespondenceConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CorrespondenceConfigurationRepository extends JpaRepository<CorrespondenceConfiguration, String> {

    @Query("SELECT cc from CorrespondenceConfiguration cc where cc.clientName=:clientName")
    List<CorrespondenceConfiguration> findByClientName(@Param("clientName") String clientName);

    @Query("SELECT cc from CorrespondenceConfiguration cc where cc.clientCertName=:clientCertName")
    List<CorrespondenceConfiguration> findByClientCertName(@Param("clientCertName") String clientCertName);

    @Query("SELECT cc from CorrespondenceConfiguration cc where cc.clientName=:clientName and cc.clientId=:clientId")
    List<CorrespondenceConfiguration> findByClientNameAndId(@Param("clientName") String clientName, @Param("clientId") String clientId);

    @Query("SELECT cc from CorrespondenceConfiguration cc where cc.clientCertName=:clientCertName and cc.clientId=:clientId")
    List<CorrespondenceConfiguration> findByClientCertNameAndId(@Param("clientCertName") String clientCertName, @Param("clientId") String clientId);
}
