package sk.sorien.silexplugin.pimple;

import com.intellij.openapi.project.Project;
import com.intellij.util.SmartFMap;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * @author Stanislav Turza
 */
public class ContainerResolver {

    private static SmartFMap<Project, Container> containers = SmartFMap.emptyMap();

    public static void putContainer(Project project, Container container) {
        containers = containers.plus(project, container);
    }

    public static void removeContainer(Project project) {
        containers = containers.minus(project);
    }

    public static Container get(Project project) {
        return containers.get(project);
    }
}
