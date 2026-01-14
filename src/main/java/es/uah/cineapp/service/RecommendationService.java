package es.uah.cineapp.service;
import es.uah.cineapp.recommendation.observer.Observer;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecommendationService implements Observer {

    private final Set<Long> dirtyUsers = ConcurrentHashMap.newKeySet();

    @Override
    public void update(Long usuarioId) {
        // Marcamos que ese usuario debe recalcular
        dirtyUsers.add(usuarioId);
    }

    public boolean needsRecompute(Long usuarioId) {
        return dirtyUsers.contains(usuarioId);
    }

    public void markClean(Long usuarioId) {
        dirtyUsers.remove(usuarioId);
    }
}
