package org.jboss.windup.graph.model;

import org.jboss.windup.graph.model.resource.FileModel;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 * Contains the global configuration for the current Windup execution.
 */
@TypeValue(WindupConfigurationModel.TYPE)
public interface WindupConfigurationModel extends WindupVertexFrame
{
    String TYPE = "BaseWindupConfiguration";

    String INPUT_PATH = "inputPath";
    String USER_RULES_PATH = "userRulesPath";
    String USER_IGNORE_PATH = "userIgnorePath";
    String OFFLINE_MODE = "fetchRemoteResources";
    String OUTPUT_PATH = "outputPath";
    String SOURCE_TECHNOLOGY = "sourceTechnology";
    String TARGET_TECHNOLOGY = "targetTechnology";
    String CSV_MODE = "csv";
    String KEEP_WORKING_DIRECTORIES = "keepWorkDirs";

    /**
     * The input path to scan
     */
    @Adjacency(label = INPUT_PATH, direction = Direction.OUT)
    FileModel getInputPath();

    /**
     * The input path to scan
     */
    @Adjacency(label = INPUT_PATH, direction = Direction.OUT)
    void setInputPath(FileModel inputPath);

    /**
     * The location for user provided rules directories (typically Groovy or XML Rules)
     */
    @Adjacency(label = USER_RULES_PATH, direction = Direction.OUT)
    void addUserRulesPath(FileModel userRulesPath);

    /**
     * The location for user provided ignore directory (list of ignored jar files)
     */
    @Adjacency(label = USER_IGNORE_PATH, direction = Direction.OUT)
    void addUserIgnorePath(FileModel userIgnorePath);

    /**
     * The location for user provided rules directories (typically Groovy or XML Rules)
     */
    @Adjacency(label = USER_RULES_PATH, direction = Direction.OUT)
    Iterable<FileModel> getUserRulesPaths();

    /**
     * The location for user provided rules directories (typically Groovy or XML Rules)
     */
    @Adjacency(label = USER_IGNORE_PATH, direction = Direction.OUT)
    Iterable<FileModel> getUserIgnorePaths();

    /**
     * Where to put the report and other files produced during Windup execution.
     */
    @Adjacency(label = OUTPUT_PATH, direction = Direction.OUT)
    FileModel getOutputPath();

    /**
     * Where to put the report and other files produced during Windup execution.
     */
    @Adjacency(label = OUTPUT_PATH, direction = Direction.OUT)
    void setOutputPath(FileModel outputPath);

    /**
     * Indicates whether or not to function in offline mode (no network access)
     */
    @Property(OFFLINE_MODE)
    boolean isOfflineMode();

    /**
     * Indicates whether or not to function in offline mode (no network access)
     */
    @Property(OFFLINE_MODE)
    void setOfflineMode(boolean offline);

    /**
     * Contains the id of the source technology (the technology being migrated from).
     */
    @Adjacency(label = SOURCE_TECHNOLOGY, direction = Direction.OUT)
    Iterable<TechnologyReferenceModel> getSourceTechnologies();

    /**
     * Contains the id of the source technology (the technology being migrated from).
     */
    @Adjacency(label = SOURCE_TECHNOLOGY, direction = Direction.OUT)
    void addSourceTechnology(TechnologyReferenceModel technology);

    /**
     * Contains the id of the target technology (the technology being migrated to).
     */
    @Adjacency(label = TARGET_TECHNOLOGY, direction = Direction.OUT)
    Iterable<TechnologyReferenceModel> getTargetTechnologies();

    /**
     * Contains the id of the target technology (the technology being migrated to).
     */
    @Adjacency(label = TARGET_TECHNOLOGY, direction = Direction.OUT)
    void addTargetTechnology(TechnologyReferenceModel technology);

    /**
     * Indicates whether or not to export CSV file
     */
    @Property(CSV_MODE)
    boolean isExportingCSV();

    /**
     * Indicates whether or not to export CSV file
     */
    @Property(CSV_MODE)
    void setExportingCSV(boolean csv);

    /**
     * Indicates whether or not to keep working directories (graph and unzipped archive data)
     */
    @Property(KEEP_WORKING_DIRECTORIES)
    Boolean isKeepWorkDirectories();

    /**
     * Indicates whether or not to keep working directories (graph and unzipped archive data)
     */
    @Property(KEEP_WORKING_DIRECTORIES)
    void setKeepWorkDirectories(Boolean keep);
}
