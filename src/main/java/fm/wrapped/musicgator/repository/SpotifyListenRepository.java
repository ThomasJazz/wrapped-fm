package fm.wrapped.musicgator.repository;

import fm.wrapped.musicgator.entity.SpotifyListenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpotifyListenRepository extends JpaRepository<SpotifyListenEntity, UUID> {
}