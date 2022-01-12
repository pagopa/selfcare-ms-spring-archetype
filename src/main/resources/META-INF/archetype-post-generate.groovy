import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.function.Predicate
import java.util.stream.Collectors

boolean deleteDirectory(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
        for (File file : allContents) {
            deleteDirectory(file);
        }
    }
    return directoryToBeDeleted.delete();
}

class RestModuleFilter implements Predicate<String> {
    @Override
    boolean test(String s) {
        return !s.trim().equals("<module>rest</module>")
    }
}

class DaoModuleFilter implements Predicate<String> {
    @Override
    boolean test(String s) {
        return !s.trim().equals("<module>dao</module>")
    }
}

class AzureStorageModuleFilter implements Predicate<String> {
    @Override
    boolean test(String s) {
        return !s.trim().equals("<module>azure-storage</module>")
    }
}

// the path where the project got generated
Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

// the properties available to the archetype
Properties properties = request.properties

String includeRestConnector = properties.get("includeRestConnector")
String includeDaoConnector = properties.get("includeDaoConnector")
String includeAzureStorageConnector = properties.get("includeAzureStorageConnector")

if (!(includeRestConnector == "true" || includeRestConnector == "yes" || includeRestConnector == "y")) {
    // delete RestConnector module
    deleteDirectory(projectPath.resolve("connector/rest").toFile())
    Path pom = projectPath.resolve("connector/pom.xml")
    Files.write(pom, Files.readAllLines(pom).stream()
            .filter(new RestModuleFilter())
            .collect(Collectors.toList()))

}
if (!(includeDaoConnector == "true" || includeDaoConnector == "yes" || includeDaoConnector == "y")) {
    // delete DaoConnector module
    deleteDirectory(projectPath.resolve("connector/dao").toFile())
    Path pom = projectPath.resolve("connector/pom.xml")
    Files.write(pom, Files.readAllLines(pom).stream()
            .filter(new DaoModuleFilter())
            .collect(Collectors.toList()))
}
if (!(includeAzureStorageConnector == "true" || includeAzureStorageConnector == "yes" || includeAzureStorageConnector == "y")) {
    // delete AzureStorageConnector module
    deleteDirectory(projectPath.resolve("connector/azure-storage").toFile())
    Path pom = projectPath.resolve("connector/pom.xml")
    Files.write(pom, Files.readAllLines(pom).stream()
            .filter(new AzureStorageModuleFilter())
            .collect(Collectors.toList()))
}
