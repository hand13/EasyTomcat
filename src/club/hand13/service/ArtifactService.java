package club.hand13.service;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.packaging.artifacts.Artifact;
import com.intellij.packaging.artifacts.ArtifactPointer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ArtifactService {
    static ArtifactService getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, ArtifactService.class);
    }
    public List<Artifact> getArtifactList();
    public List<ArtifactPointer> getArtifactPointers();
}
