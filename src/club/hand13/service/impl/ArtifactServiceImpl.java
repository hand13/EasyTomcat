package club.hand13.service.impl;

import club.hand13.service.ArtifactService;
import com.intellij.facet.frameworks.beans.Artifacts;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.packaging.artifacts.Artifact;
import com.intellij.packaging.artifacts.ArtifactPointer;
import com.intellij.packaging.artifacts.ArtifactPointerManager;
import com.intellij.packaging.impl.artifacts.ArtifactUtil;

import java.util.ArrayList;
import java.util.List;

public class ArtifactServiceImpl implements ArtifactService {
    private Project project;

    public ArtifactServiceImpl(Project project) {
        this.project = project;
    }

    @Override
    public List<Artifact> getArtifactList() {
        return ArtifactUtil.getArtifactWithOutputPaths(project);
    }

    @Override
    public List<ArtifactPointer> getArtifactPointers() {
        List<ArtifactPointer> aps = new ArrayList<>();
        ArtifactPointerManager apm = ArtifactPointerManager.getInstance(this.project);
        List<Artifact> as = this.getArtifactList();
        for (Artifact artifact : as) {
            aps.add(apm.createPointer(artifact));
        }
        return aps;
    }
}
