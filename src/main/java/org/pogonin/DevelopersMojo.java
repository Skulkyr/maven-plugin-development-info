package org.pogonin;

import org.apache.maven.model.Developer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "show-developers", defaultPhase = LifecyclePhase.VALIDATE)
public class DevelopersMojo extends AbstractMojo {

    @Component
    private MavenProject project;

    @Override
    public void execute() {
        List<Developer> developers = project.getDevelopers();

        if (developers == null || developers.isEmpty()) {
            getLog().info("No developers found");
            return;
        }

        getLog().info("Found " + developers.size() + " developers");
        for (Developer developer : developers) {
            getLog().info(developer.toString());
        }
    }
}