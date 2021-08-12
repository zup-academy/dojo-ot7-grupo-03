package br.com.zup.edu.nossositedeviagens.repositorio;

import br.com.zup.edu.nossositedeviagens.modelo.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportoRepository  extends JpaRepository<Aeroporto, Long> {
}
