package projeto.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.api.rest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	


}
