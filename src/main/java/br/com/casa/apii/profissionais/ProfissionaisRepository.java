package br.com.casa.apii.profissionais;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface ProfissionaisRepository extends JpaRepository<Profissionais, Long> {
    Page<Profissionais> findAllByAtivoTrue(Pageable pageable);
}
